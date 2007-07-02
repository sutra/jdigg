<%@ include file="/taglibs.jsp" %>
  <script type="text/javascript">
    var reply0 = function(data)
    {
      if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
      else dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
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
<a href="<c:url value="/${story.id}" />" class="more">More&#8230;
</a>
</p>

${story.rank} diggs

<a href="javascript:User.digg('${story.id}', reply0)">Digg</a>
<a href="<c:url value="/users/${story.digger.id}" />"><c:out value="${story.digger.nickname}" escapeXml="true" /></a>
 submitted.

<a href="javascript:User.bury('${story.id}', reply0)">Bury</a>

</div>
</c:forEach>