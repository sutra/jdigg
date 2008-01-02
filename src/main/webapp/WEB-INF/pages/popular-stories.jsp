<%@ include file="/taglibs.jsp" %>
<script>
function errorHandler(message, exception) {
	if (message != null && message != "") {
		alert(message);
	} else if (exception.javaClassName === "com.redv.jdigg.UserNotLoginException") {
		alert("Not login.");
	} else if (exception.javaClassName === "com.redv.jdigg.StoryNotFoundException") {
		alert("Story not found.");
	} else if (exception.javaClassName === "com.redv.jdigg.UserNotFoundException") {
		alert("User not found.");
	}
}

function init() {
	dwr.util.useLoadingMessage();
	dwr.engine.setErrorHandler(errorHandler)
}

if (window.addEventListener) {
	window.addEventListener("load", init, false);
} else if (window.attachEvent) {
	window.attachEvent("onload", init);
} else {
	window.onload = init;
}
</script>
<script type="text/javascript">
	var reply0 = function(data) {
		if (data != null && typeof data == 'object') dwr.util.setValue('diggs_' + data.id, data.votes);
	}
</script>
<c:forEach items="${stories}" var="story">
<div>

<h3>
<a href="<c:out value="${story.url}" escapeXml="true" />">
<c:out value="${story.title}" escapeXml="true" />
</a>
</h3>

<p>
<c:out value="${story.body}" escapeXml="true" />
&nbsp;
<!-- 
<a href="<c:url value="/${story.id}" />" class="more">More&#8230;
</a>
 -->
</p>

<span id="diggs_${story.id}">${story.votes}</span> diggs
|
<a href="javascript:User.digg('${story.id}', {callback:reply0,errorHandler:errorHandler})">Digg</a>
|
<a href="javascript:User.bury('${story.id}', reply0)">Bury</a>
|
<a href="<c:url value="/users/${story.digger.id}" />"><c:out value="${story.digger.nickname}" escapeXml="true" /></a>
 submitted.
</div>
</c:forEach>

<div class="pageBar">
<a href="?firstResult=${firstResult - maxResults}&maxResults=${maxResults}"><fmt:message key="Previous" /></a>
<a href="?firstResult=${firstResult + maxResults}&maxResults=${maxResults}"><fmt:message key="Next" /></a>
</div>