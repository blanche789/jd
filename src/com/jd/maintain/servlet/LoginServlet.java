package com.jd.maintain.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.common.MD5Encrypt;
import com.jd.maintain.dao.UserInfoDao;
import com.jd.maintain.dto.UserInfoDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/maintain/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("iso-8859-1");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserInfoDao uid = new UserInfoDao();
		UserInfoDto userInfoDto = uid.queryByUserName(userName);
		if(userInfoDto != null) {
			
			if(MD5Encrypt.validatePassword(password, userInfoDto.getPassword())) {
				RequestDispatcher rd = request.getRequestDispatcher("../LoginSuccess.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("√‹¬Î¥ÌŒÛ");
				response.sendRedirect("../login.html?flag=false");
			}
			
		}else {
				System.out.println("”√ªß√˚¥ÌŒÛ");
			response.sendRedirect("../login.html?flag=false");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
