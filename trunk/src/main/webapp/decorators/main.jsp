<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>jdigg - <decorator:title default="Welcome!" />
		</title>
		<meta http-equiv="Content-Type"
			content="application/xhtml-xml; charset=UTF-8" />
		<meta content="all" name="robots" />
		<script src='${ctx}/dwr/interface/Digg.js'></script>
		<script src='${ctx}/dwr/interface/User.js'></script>
		<script src='${ctx}/dwr/engine.js'></script>
		<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
<style type="text/css">
label {
display: block;
}
</style>

		<decorator:head />
	</head>
	<body>
		<div>
		<c:choose>
		<c:when test="${currentUser == null}">
		<form action="login.html" method="post">
			<input type="text" name="openid_url" />
			<input type="submit" value="Login" />
		</form>
		</c:when>
		<c:otherwise>
		<a href="<c:url value="/profile.html" />">
		<c:out value="${currentUser.openid}" />
		</a>
		</c:otherwise>
		</c:choose>
		</div>
		<div>
		<a href="<c:url value="/popular-stories.html" />">Popular Stories</a>
		<a href="<c:url value="/submit.html" />">Submit a New Story</a>
		</div>
		<div>
			<decorator:body />
		</div>
	</body>
</html>
