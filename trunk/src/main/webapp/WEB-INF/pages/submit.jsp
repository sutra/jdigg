<%@ include file="/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<form:form>
<fieldset>
<legend><fmt:message key="Submit_a_New_Story" /></legend>
	<label for="url" accesskey="1">Enter the URL of the Story</label>
	<form:input path="url" cssClass="story_url" />
	<form:errors path="url" />
	<label for="title" accesskey="2">Title</label>
	<form:input path="title" cssClass="story_title" />
	<label for="body" accesskey="3">Body</label>
	<form:textarea path="body" cssClass="story_body" />
</fieldset>

<input type="submit" value="<fmt:message key="Continue" />" />
</form:form>
</body>
</html>