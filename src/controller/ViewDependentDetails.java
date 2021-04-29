package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

import beans.Dependent;
import beans.Employee;
import dao.UserDAO;

/**
 * Servlet implementation class ViewDependentDetails
 */
public class ViewDependentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDependentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("empid")!=null){
			int empid=Integer.parseInt(request.getParameter("empid"));
			UserService us=new UserService();
			ArrayList<Dependent> dlist=us.searchDependent(empid);
			request.setAttribute("dlist", dlist);
			RequestDispatcher rd=request.getRequestDispatcher("ViewDependentDetails.jsp");
			rd.forward(request, response);
		}
		else{
		int did=Integer.parseInt(request.getParameter("did"));
		UserDAO ud=new UserDAO();
		Dependent dep=ud.viewDependentDetails(did);
		request.setAttribute("dependent", dep);
		RequestDispatcher rd=request.getRequestDispatcher("ViewDependentDetails.jsp");
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
