<%@include file="/taglibs.jsp"%>
<div id="dir" style="text-align: left;margin-bottom:40px;">
<div class="cat_display">
<c:forEach items="${categories}" var="category">
	<a href="<c:url value="${category.name}-c.html" />">${category.title}</a>
</c:forEach>
</div>
</div>
<div style="text-align: center;"><h2><fmt:message key="menu.New_Sites" /></h2></div>
<%@ include file="popular-stories.jsp" %>