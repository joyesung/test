<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
 
</head>
<div style="min-height: 561px">
	<h1>게시글 수정</h1>
		<form method="post" action="<%=request.getContextPath() %>/board/modify">
		<input type="hidden" value="${board.num}" name="num">
			<div class="form-group col-4 mb-0">
  				<input type="text" class="form-control" name="title" value="${board.title}">
			</div>
			<div class="form-group col-4 mb-0">
  				<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
			</div>
			<textarea id="summernote" name="contents">${board.contents}</textarea>
			<button type="submit" class="btn btn-danger">수정하기</button>
		</form>
</div>

<script>
$(document).ready(function(){
	$('#summernote').summernote({
		  placeholder: 'Hello bootstrap 4',
		  tabsize: 2,
		  height: 300,
		  lang: 'ko-KR'
	});	
});
</script>