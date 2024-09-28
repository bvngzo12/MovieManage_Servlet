<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var = "sess" value="${member}"></c:set>
<c:set var = "root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
		<div>
		<c:if test="${sess ne null}">
			<span> ${sess.id} 님 로그인 중</span> 
			<a href="${root}/member.do?act=logout">로그아웃</a>
		</c:if>
		<c:if test="${empty sess}">
			<a href="${root}/member.do?act=loginform">로그인</a>
		</c:if>
			<a href="${root}/member.do?act=init">초기화면</a>
		</div>
