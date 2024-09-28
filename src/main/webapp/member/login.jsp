<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<c:set var="id" value=""></c:set>

<c:if test="${cookie.name eq 'idsaved'}">
	<c:set var="id" value="${cookie.value}"></c:set>
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<h2>${myCookie}</h2>
		<form id="login" action="${root}/member.do?act=login" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<c:if test="${id eq null}">
						<td><input type="text" name="id" value="" /></td>
						<td><input type="checkbox" name="save" /></td>
					</c:if>
					<c:if test="${id ne null}">
						<td><input type="text" name="id" value="${id}" /></td>
						<td><input type="checkbox" name="save" checked /></td>
					</c:if>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td colspan="2"><input type="text" name="pw" /></td>
				</tr>
			</table>
			<input type="submit" value="로그인" />
		</form>
	</div>
</body>
</html>