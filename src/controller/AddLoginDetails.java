package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TPAService;
import service.UserService;

import dao.UserDAO;

/**
 * Servlet implementation class AddLoginDetails
 */
public class AddLoginDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLoginDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession(false).getAttribute("set")!=null){
			int empid=Integer.parseInt(request.getParameter("EmpId"));
			TPAService ts=new TPAService();
			int a=ts.addLoginDetails(empid);
			request.setAttribute("added", a);
			RequestDispatcher rd=request.getRequestDispatcher("AddLoginDetails.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
