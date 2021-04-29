package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import beans.Login;

import service.UserService;

/**
 * Servlet implementation class RegisterEmployee
 */
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession(false).getAttribute("login")!=null){
		Login l=(Login)request.getSession(false).getAttribute("login");
		UserService us=new UserService();
		Employee emp=us.searchEmployee(l.getEmpId());
		request.getSession(false).setAttribute("employee", emp);
		RequestDispatcher rd=request.getRequestDispatcher("empReg.jsp");
		rd.forward(request, response);
		}else{
			response.sendRedirect("loginEmp.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
