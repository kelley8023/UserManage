package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PageHelper;
import com.bean.People;
import com.dao.PeopleDao;

/**
 * Servlet implementation class peopleListServlet
 */
@WebServlet("/peopleList")
public class PeopleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PeopleListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// 当前页显示的多少条数据（不是必须的参数）
		int currentPerCount;
		//当前的页码（必传的参数）
		int currentPage;
		
		String pagePerCount = request.getParameter("count");
		String pageString = request.getParameter("page");
		System.out.println("pagePerCount:" + pagePerCount);
		if (pagePerCount != "" && pagePerCount != null) {
			currentPerCount = Integer.valueOf(pagePerCount);
		} else {
			currentPerCount = 5;
		}
		if (pageString != null && pageString !="") {
			currentPage = Integer.valueOf(pageString);
		} else {
			currentPage = 1;
		}

		PeopleDao peopleDao = new PeopleDao();

		// 用户总数
		int totalPeople = peopleDao.getAllPeopleCount();
		
		PageHelper pageHelper = new PageHelper(totalPeople, currentPerCount);
		
		// 数据开始下标
		int peopleStartIndex = pageHelper.getCurrentPageStart(currentPage);
		
		//总页数
		int totalPage = pageHelper.getTotalPage();
		
		// 数据列表的获取
		ArrayList<People> userList = peopleDao.getUserList(peopleStartIndex, currentPerCount);
		request.setAttribute("peopleList", userList);
		request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPeople", totalPeople);
        request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("peopleList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doGet(request, response);
	}
}
