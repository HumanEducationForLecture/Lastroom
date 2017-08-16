<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id=wrap align=center>
		<h1>Sign Up</h1>
		<form name="insertUser" method="post" action="">
			<table>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" size="20"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" size="20"></td>
				</tr>
				<tr>
					<td>Password Check</td>
					<td><input type="password" name="password" size="20"></td>
				</tr>
				<tr>
					<td>NickName</td>
					<td><input type="text" name="nickname" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="insertUser">
						<input type="button" value="메인화면" onclick="location.href=''">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>