<%@ include file="/taglibs.jsp" %>
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
<a href="<c:url value="/${story.id}" />" class="more">More&#8230;
</a>
</p>

${story.rank} diggs
<a href="<c:url value="/users/${story.digger.id}" />"><c:out value="${story.digger.nickname}" escapeXml="true" /></a>
 submitted.

</div>
</c:forEach>