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
 * Servlet implementation class EditPeopleServlet
 */
@WebServlet("/editPeople")
public class EditPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPeopleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取当前编辑用户的信息
		
		String uId=request.getParameter("id");
		int pId = Integer.valueOf(uId);
		System.out.println("uId:"+uId);
		PeopleDao peopleDao = new PeopleDao();
		People people = peopleDao.findPeopleById(pId);
		//  findBooksByPeopleId（uid）
		System.out.println("people:"+people);
		request.setAttribute("people", people);
		//request.setAttribute("books", "bookList");
		request.setAttribute("uid", uId);
		request.getRequestDispatcher("editPeople.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	
		String pId = request.getParameter("id");
		String username = request.getParameter("username");
		String sexString = request.getParameter("sex");
		String birthPlace = request.getParameter("birthplace");
		People people = new People();
		people.id= Integer.valueOf(pId);
		people.username = username;
		people.sex = Integer.valueOf(sexString);
		people.birthplace = birthPlace;
		
		PeopleDao peopleDao = new PeopleDao();
		boolean result = peopleDao.updatePeople(people);
		if(result) {
			request.getRequestDispatcher("/peopleList").forward(request, response);
		}else {
			request.getRequestDispatcher("/editPeople.jsp").forward(request, response);
		}
	}

}
