<%@ include file="/taglibs.jsp"%>
<form:form>
	<label for="openid" accesskey="1">OpenID</label>
	<form:input path="openid" disabled="true" cssClass="sexy" cssStyle="width:80%" />
	<label for="nickname" accesskey="2">Nickname</label>
	<form:input path="nickname" />
	<input type="submit" value="Save" />
</form:form>
