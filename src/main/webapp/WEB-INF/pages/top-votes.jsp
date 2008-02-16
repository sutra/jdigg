<%@ include file="/taglibs.jsp" %>
<div style="text-align: center;">
<c:if test="${!empty category}">
<h1 style="text-align: center; font-size: 14px;"><a href="<c:url value="./" />" title="Home">Home</a> &gt; <a href="<c:url value="${category.name}-c.html" />">${category.title}</a></h1>
</c:if>
</div>
<c:if test="${empty category}">
<div id="message" style="text-align: center;">
<h2>Top 10 Top Votes</h2>
</div>
</c:if>
<%@ include file="popular-stories.jsp" %>