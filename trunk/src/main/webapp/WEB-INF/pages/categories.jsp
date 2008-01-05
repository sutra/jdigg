<%@include file="/taglibs.jsp"%>
<div id="message" style="text-align: center;">
<h2>All categories</h2>
</div>
<c:forEach items="${categories}" var="category">
<a href='./' title='Home'>Home</a> &gt; <a href="${category.name}-c.html">${category.title}</a><br />
</c:forEach>