<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="movie" value="${movie}"></c:set>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update(){
		document.getElementById("detail").action = "${root}/movie.do?act=update"
		document.getElementById("detail").submit();
	}
	
	
	function remove(){
		document.getElementById("detail").action = "${root}/movie.do?act=delete"
		document.getElementById("detail").submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>영화 상세</h1>
		<form id="detail" action = "" method="post">
			<table border="1">
				<tr>
					<td>영화 코드</td>
					<td><input type="text" name="code" value="${movie.code}" readonly /></td>
				</tr>
				<tr>
					<td>영화 제목</td>
					<td><input type="text" name="title" value="${movie.title}" /></td>
				</tr>
				<tr>
					<th>러닝 타임</th>
					<td><input type="text" name="time" value="${movie.time}" /></td>
				</tr>
				<tr>
					<th>영화 감독</th>
					<td><input type="text" name="director" value="${movie.director}" /></td>
				</tr>
				<tr>
					<th>영화 장르</th>
					<td><input type="text" name="genre" value="${movie.genre}" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type = "button"  onclick="update()" value="수정"/>
						<input type = "button"  onclick="remove()" value="삭제"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>