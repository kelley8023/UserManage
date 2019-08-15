package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.People;
import com.dao.PeopleDao;

/**
 * Servlet implementation class RegisterServlet
 */

/** 
 * controller  接口
service   服务

m - v -c 

m : model     javaBean
v : view      jsp
c : controller   servlet

service 服务 controller

controller: registerServlet
service :数据库交互
*/



@WebServlet("/registerServlet")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();	
		out.print("<p>123</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		//设置字符集
		request.setCharacterEncoding("utf-8");
		//获取session	
//		HttpSession session = request.getSession();
//			
//		Cookie[] aCookie = request.getCookies();
//		for (Cookie cookie : aCookie) {
//			System.out.println(cookie);
//		}
//		
//		Enumeration paramNames = request.getParameterNames();     
//		while(paramNames.hasMoreElements()) {       
//			String paramName = (String)paramNames.nextElement();       
//		    System.out.println("sEnum===="+paramName);
//		}
		
		
	//	System.out.println("username:"+request.getParameter("username"));
        
		//页面数据接收 (这种方式获取，只适合当前页面没有文件上传)
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String confirmPwd = request.getParameter("confirmPwd");
		String sexString = request.getParameter("sex");
		int sex = Integer.valueOf(sexString);
		String birthplace = request.getParameter("birthplace");
		People people = new People(username, pwd, confirmPwd, sex, birthplace);
		//数据交互的接口
		PeopleDao peopleDao = new PeopleDao();
		boolean hasRegister = peopleDao.register(people);
		//HashMap result = new HashMap();	
		if(hasRegister) {
			//result.put("result", "success");
			request.setAttribute("result", "success");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			//result.put("result", "error");
			request.setAttribute("result", "error");
			request.getRequestDispatcher("register.jsp").forward(request, response);

		}
	}

}
