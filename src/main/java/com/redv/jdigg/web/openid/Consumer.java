/**
 * Created on 2007-3-20 下午11:54:47
 */
package com.redv.jdigg.web.openid;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openid4java.OpenIDException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageExtension;
import org.openid4java.message.ParameterList;
import org.openid4java.message.sreg.SRegMessage;
import org.openid4java.message.sreg.SRegRequest;
import org.openid4java.message.sreg.SRegResponse;

import com.redv.jdigg.domain.User;

/**
 * @author Sutra Zhou
 * 
 */
public class Consumer {
	private ConsumerManager manager;

	public Consumer(ConsumerManager consumerManager) {
		this.manager = consumerManager;
	}

	// --- placing the authentication request ---
	public String authRequest(String userSuppliedString,
			HttpServletRequest httpReq, HttpServletResponse httpResp)
			throws IOException {
		try {
			// configure the return_to URL where your application will
			// receive
			// the authentication responses from the OpenID provider
			String returnToUrl = httpResp.encodeURL(httpReq.getRequestURL().toString());

			// perform discovery on the user-supplied identifier
			List discoveries = manager.discover(userSuppliedString);

			// attempt to associate with the OpenID provider
			// and retrieve one service endpoint for authentication
			DiscoveryInformation discovered = manager.associate(discoveries);

			// store the discovery information in the user's session
			httpReq.getSession().setAttribute("openid-disc", discovered);

			// obtain a AuthRequest message to be sent to the OpenID
			// provider
			AuthRequest authReq = manager.authenticate(discovered, returnToUrl);

			// Simple Registration extenstion: fetching the 'nickname' attribute
			SRegRequest sregReq = SRegRequest.createFetchRequest();
			sregReq.addAttribute("nickname", true);

			// attach the extension to the authentication request
			authReq.addExtension(sregReq);

			// if (!discovered.isVersion2()) {
			// Option 1: GET HTTP-redirect to the OpenID Provider endpoint
			// The only method supported in OpenID 1.x
			// redirect-URL usually limited ~2048 bytes
			httpResp.sendRedirect(authReq.getDestinationUrl(true));
			return null;
			// } else {
			// Option 2: HTML FORM Redirection (Allows payloads >2048 bytes)

			// RequestDispatcher dispatcher =
			// getServletContext().getRequestDispatcher("formredirection.jsp");
			// httpReq.setAttribute("prameterMap",
			// response.getParameterMap());
			// httpReq.setAttribute("destinationUrl",
			// response.getDestinationUrl(false));
			// dispatcher.forward(request, response);
			// }
		} catch (OpenIDException e) {
			// present error to the user
			httpResp.getWriter().write("Error: " + e.getMessage());
		}

		return null;
	}

	// --- processing the authentication response ---
	public User verifyResponse(HttpServletRequest httpReq) {
		try {
			// extract the parameters from the authentication response
			// (which comes in as a HTTP request from the OpenID provider)
			ParameterList response = new ParameterList(httpReq
					.getParameterMap());

			// retrieve the previously stored discovery information
			DiscoveryInformation discovered = (DiscoveryInformation) httpReq
					.getSession().getAttribute("openid-disc");

			// extract the receiving URL from the HTTP request
			StringBuffer receivingURL = httpReq.getRequestURL();
			String queryString = httpReq.getQueryString();
			if (queryString != null && queryString.length() > 0)
				receivingURL.append("?").append(httpReq.getQueryString());

			// verify the response; ConsumerManager needs to be the same
			// (static) instance used to place the authentication request
			VerificationResult verification = manager.verify(receivingURL
					.toString(), response, discovered);

			// examine the verification result and extract the verified
			// identifier
			Identifier verified = verification.getVerifiedId();
			if (verified != null) {
				User user = new User();
				user.setOpenid(verified.getIdentifier());
				AuthSuccess authSuccess = (AuthSuccess) verification
						.getAuthResponse();
				if (authSuccess.hasExtension(SRegMessage.OPENID_NS_SREG)) {
					MessageExtension ext = authSuccess
							.getExtension(SRegMessage.OPENID_NS_SREG);
					if (ext instanceof SRegResponse) {
						SRegResponse sregResp = (SRegResponse) ext;
						String nickname = sregResp
								.getAttributeValue("nickname");
						user.setNickname(nickname);
					}
				}

				return user; // success
			}
		} catch (OpenIDException e) {
			// present error to the user
		}

		return null;
	}
}
