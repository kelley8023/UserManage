package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.People;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class UserFlush
 */
@WebServlet("/userList")
public class UserFlush extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFlush() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    List<People> arrayList = new ArrayList<People>();
	    
	    arrayList.add(new People("lisi",1));
	    arrayList.add(new People("zhangsan",0));
	    arrayList.add(new People("name01",0));
	    arrayList.add(new People("namw02",0));
	    arrayList.add(new People("name03",0));
	    arrayList.add(new People("name04",0));
	
	    System.out.println("============");
	    System.out.println("============:"+arrayList);
	    request.setAttribute("userInfoList", arrayList); 
	   
	    for (People people : arrayList) {
			System.out.println(people.username);
		}
	    request.getRequestDispatcher("userListTemplate.jsp").forward(request, response);
	    	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
