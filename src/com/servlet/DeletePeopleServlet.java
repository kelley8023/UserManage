package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.People;
import com.dao.PeopleDao;

/**
 * Servlet implementation class DeletePeopleServlet
 */
@WebServlet("/deletePeople")
public class DeletePeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePeopleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pId = request.getParameter("id");
			
		//数据库交互删除用户
		
		PeopleDao peopleDao = new PeopleDao();
		People people = peopleDao.findPeopleById(Integer.valueOf(pId));
		boolean result = peopleDao.deletePeopleById(Integer.valueOf(pId));
		if(!result) {
			//有错误抛到前台，原因：当前删除这条数据，有外键关联。（会有一个表与它是从属关系）
			request.setAttribute("message", people.username+"删除失败");
		}
		request.getRequestDispatcher("/peopleList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
