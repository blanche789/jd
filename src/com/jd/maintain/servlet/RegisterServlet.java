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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/maintain/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String validateCode = request.getParameter("validateCode");
		UserInfoDao uid = new UserInfoDao();
		UserInfoDto userInfoDto = new UserInfoDto();
		RequestDispatcher rd = null;
		if(uid.queryByUserName(userName) != null) {
			System.out.println("用户名已存在");
			 rd = request.getRequestDispatcher("../alreadyRegister.jsp");
		}else {
		System.out.println("用户信息成功保存到数据库" );
		userInfoDto.setUserName(userName);
		userInfoDto.setPassword(MD5Encrypt.encryptByMD5(password));
		userInfoDto.setTelephone(telephone);
		uid.saveUser(userInfoDto);
		rd = request.getRequestDispatcher("../RegisterSuccess.jsp");
		}
		rd.forward(request, response);
	}

}
