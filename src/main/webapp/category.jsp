<%@include file="/taglibs.jsp"%>
<input type="hidden" id="id" name="id" />
<label for="name">Name</label>
<input type="text" id="name" name="name" />
<label for="title">Title</label>
<input type="text" id="title" name="title" />
<button onclick="User.saveCategory({id:$('id').value==''?null:$('id').value, name:$('name').value, title:$('title').value})">Save</button>
