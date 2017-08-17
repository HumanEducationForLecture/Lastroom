<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify.do" method="post">
		<input type="hidden" name="email" value="${post_view }">
		<table width="500" cellpadding="0" cellspacing="0" boarder="1">
			<tr>
				<td>번호</td>
				<td>${post_view.indexNum }</td>
			</tr>
			<tr>
				<td>별명</td>
				<td><input type="text" name="bName"
					value="${post_view.nickName }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="bContent"
					value="${post_view.content }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;
					<a href="postList.jsp">목록보기</a>&nbsp; <a
					href="delete.do?email=${post_view.email }">삭제</a>&nbsp; <a
					href="reply_view.do?email=${post_view.email }">답글달기</a>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>