<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
 
</head>
<div style="min-height: 561px">
	<h1>게시글 등록</h1>
		<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath() %>/board/register">
			<div class="form-group col-4 mb-0">
  				<input type="text" class="form-control" name="title" placeholder="제목">
			</div>
			<div class="form-group col-4 mb-0">
  				<input type="text" class="form-control" name="writer" value="${user.id}" readonly>
			</div>
			<textarea id="summernote" name="contents"></textarea>
			<input type="file" class="form-control-file border" name=" file2">
			<button type="submit" class="btn btn-danger">등록</button>
		</form>
</div>

<script>
$(document).ready(function(){
	$('#summernote').summernote({
		  placeholder: 'Hello bootstrap 4',
		  tabsize: 2,
		  height: 100,
		  lang: 'ko-KR'
	});	
});
</script>