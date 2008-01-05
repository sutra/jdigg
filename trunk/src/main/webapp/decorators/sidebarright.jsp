<%@ include file="/taglibs.jsp" %>
<div>
<c:choose>
<c:when test="${currentUser == null}">
<form action="login.html" method="post">
	<input type="text" name="openid_identifier" class="sexy" style="width:80%;" />
	<input type="submit" value="<fmt:message key="Login" />" />
</form>
<div align="center"><a href="/openid-providers-c-1.html">No OpenID? Get one <b>here!</b></a></div>
</c:when>
<c:otherwise>
<fieldset>
<legend><img alt="" src="${ctx}/themes/fresh/images/login-bg.gif" /></legend>
logged in as
<a href="<c:url value="/users/${currentUser.id}" />"><c:out value="${currentUser.nickname}" /></a><br />
<a href="<c:url value="/profile.html" />">&gt;&gt; Member Area</a><br />
<a href="<c:url value="/logout.html" />">&gt;&gt; <fmt:message key="Logout" /></a>
</fieldset>
</c:otherwise>
</c:choose>
</div>
<%--
<h2>Search</h2>
<div id="recherche">
<form action="recherche.html" method="post">

<p><input type="text" name="seek" id="search" size="18" maxlength="80" value="" /><input type="submit" value="go" /></p>
</form>
</div>
<h2>Tag Cloud</h2>
<div style="text-align: center; background: #EEE; border: 1px solid #CCC;">
<a href="" style="font-size: 10px; padding: 5px;"></a>
</div>
<h2>Top Searches</h2>
<ul class="subnav">
<li><a href=""></a></li>
</ul>
<h2>Top Hits</h2>
<ul class="subnav">
<li><a href=""></a></li>
</ul>
<h2>Feeds</h2>

<ul class="subnav">
<li><a href="rss">Subscribe (RSS)</a></li>
<li><a href="atom">Subscribe (ATOM)</a></li>
</ul>
--%>