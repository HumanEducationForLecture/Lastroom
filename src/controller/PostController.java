package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.PostDao;
import dao.TUserDao;
import user.PostDTO;
import user.UserDTO;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubrequest.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String nickName = request.getParameter("nickname"); 
		
		try {
			new PostDao().insert(new PostDTO(email,nickName,content,null));
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			new PostDao().delete(new PostDTO(email,null,null,password));
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
				
	}

	/**
	 * �닔�젙�븷�븣 
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		try {
			new PostDao().insert(new PostDTO(email,null,content,password));
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
