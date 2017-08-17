<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write_view.do</title>
</head>
<body>
	글쓰기
	<!--  write_view.do 사용자 입력 페이지 호출 -->
	<!--  write.do 사용자가 입력한 글을 저장 -->
	<form action="write.do">
		<table width="500" border="1">
			<tr>
				<td>별명</td>
				<td><input type="text" name="nickName" size="50"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="50"></td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td><textarea name="content" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;
					<a href="postList.jsp">목록보기</a></td>
			</tr>

		</table>
	</form>

</body>
</html>