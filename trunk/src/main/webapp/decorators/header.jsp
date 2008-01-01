<%@ include file="/taglibs.jsp" %>

<a href="<c:url value="/" />" title="Home"><img src="http://openiddirectory.com/themes/fresh/images/OpenIDDirectory_Logo_horizontal_353_subtitle.png" alt="<fmt:message key="title" />" border="0" /></a>

<ul id="nav">
<li><a href="nouveautes.html" title="New Sites"><fmt:message key="menu.New_Sites" /></a></li>
<li><a href="<c:url value="/top-votes.html" />" title="Top Votes"><fmt:message key="menu.Top_Votes" /></a></li>
<li><a href="top-hits.html" title="Top 10 Hits"><fmt:message key="menu.Top_Hits" /></a></li>
<li><a href="top-rank.html" title="Top Rank"><fmt:message key="menu.Top_Rank" /></a></li>
<li><a href="keywords.html" title="Keywords"><fmt:message key="menu.Keywords" /></a></li>
<li><a href="allcats.html" title="Categories"><fmt:message key="menu.Categories" /></a></li>
<li><a href="<c:url value="/submit.html" />" title="Submit a site"><fmt:message key="menu.Submit_a_site" /></a></li>
</ul>



<%--
		<div>
		<c:choose>
		<c:when test="${currentUser == null}">
		<form action="login.html" method="post">
			<input type="text" name="openid_url" class="sexy" />
			<input type="submit" value="<fmt:message key="Login" />" />
		</form>
		</c:when>
		<c:otherwise>
		<a href="<c:url value="/profile.html" />">
		<c:out value="${currentUser.openid}" />
		</a>
		<a href=""><fmt:message key="Logout" /></a>
		</c:otherwise>
		</c:choose>
		</div>
--%>