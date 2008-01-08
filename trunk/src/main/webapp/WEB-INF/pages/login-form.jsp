<%@ include file="/taglibs.jsp" %>
<form action="<c:url value="/login.html" />" method="post">
	<input type="text" name="openid_identifier" class="sexy" style="width:80%;" />
	<input type="submit" value="<fmt:message key="Login" />" />
</form>