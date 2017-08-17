<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>별명</td>
			<td>이메일</td>
			<td>자기소개</td>
		</tr>
		<c:forEach items="${list }" var="PostDto">
			<tr>
				<td>${PostDto.indexNum }</td>
				<td>${PostDto.nickName }</td>
				<td><a href="post_view.do?email=${PostDto.email }">${PostDto.content }</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.jsp">글작성</a></td>
		</tr>
	</table>
</body>
</html>