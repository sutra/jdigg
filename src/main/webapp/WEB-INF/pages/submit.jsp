<%@ include file="/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<form:form>
<fieldset class="Submit_a_New_Story">
<legend><fmt:message key="Submit_a_New_Story" /></legend>
	<label for="url" accesskey="1">Enter the URL of the Story</label>
	<form:input path="url" cssClass="story_url" /><br />
	<form:errors path="url" cssClass="error" />
	<label for="title" accesskey="2">Title</label>
	<form:input path="title" cssClass="story_title" />
	<label for="category accesskey="3">Category</label>
	<form:select path="category">
		<form:option value="" label="--Please Select"/>
		<form:options items="${categories}" itemValue="id" itemLabel="title" />
	</form:select>
	<form:errors path="category" cssClass="error" />
	<label for="body" accesskey="4">Body</label>
	<form:textarea path="body" cssClass="story_body" />
</fieldset>

<input type="submit" value="<fmt:message key="Continue" />" />
</form:form>
</body>
</html>