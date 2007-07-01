<%@ include file="/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<form:form>
<fieldset>
<legend>Submit a New Story</legend>
	<label for="url" accesskey="1">Enter the URL of the Story</label>
	<form:input path="url" cssClass="form-text" />
	<label for="title" accesskey="2">Title</label>
	<form:input path="title" />
	<label for="body" accesskey="3">Body</label>
	<form:textarea path="body" />
</fieldset>

<input type="submit" value="Continue" />
</form:form>
</body>
</html>