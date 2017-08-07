<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty property="userID" name="user"/>
<jsp:setProperty property="userPassword" name="user"/>
<jsp:setProperty property="userName" name="user"/>
<jsp:setProperty property="userGender" name="user"/>
<jsp:setProperty property="userEmail" name="user"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID")!=null)
		{
			userID = (String)session.getAttribute("userID");
		}
		if(userID != null)
		{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인 되어있습니다.')");
			script.println("location.href = main.jsp");
			script.println("</script>");
		}
		if(user.getUserID()==null || user.getUserPassword()==null || user.getUserName()==null
			|| user.getUserGender()==null || user.getUserEmail()==null)
		{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('모든 사항을 입력하셔야 합니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else
		{
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			if(result==-1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디입니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else if(result==0)
			{
				session.setAttribute("userID", user.getUserID());
				PrintWriter script = response.getWriter();
				
				
			}
		}
		
	%>
	<h2>가입 신청이 완료 되었습니다!</h2>
	<a href="main.jsp">메인 화면으로 가기</a>
</body>
</html>