<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 페이지</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

nav {
	display: flex;
	justify-content: space-between;
	align-items: center
}

nav a {
	margin-right: 10px
}
</style>
</head>
<body>
	<nav>
		<h1>영화 목록 페이지</h1>
	</nav>
	<a href="${root}/movie.do?act=init">메인 화면으로</a>
	<a href="${root}/movie.do?act=registform">등록하기</a>
	<form action = "${root}/movie.do?act=deleteSelected" method="POST">
		<table>
			<thead>
				<tr>
					<th>영화 코드</th>
					<th>영화 제목</th>
					<th>영화 장르</th>
					<th>영화 선택</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movie" items="${movies}">
					<tr>
						<td>${movie.code}</td>
						<td><a href="${root}/movie.do?act=detail&code=${movie.code}">${movie.title}</a></td>
						<td>${movie.genre}</td>
						<td><input type="checkbox" name="chk" value="${movie.code}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type = "submit" value ="일괄 삭제"/>
	</form>
</body>
</html>