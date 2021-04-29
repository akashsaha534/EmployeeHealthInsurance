package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

import beans.Employee;
import beans.Login;

import dao.UserDAO;

/**
 * Servlet implementation class SearchEmployee
 */
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int EmpId=Integer.parseInt(request.getParameter("EmpId"));
		String Password=request.getParameter("password");
		UserService us=new UserService();
		Login l=us.searchLogin(EmpId);
		Employee e=us.viewEmployeeDetails(EmpId);
		if(l!=null){
			if(l.getPassword().equals(Password)){
			request.getSession(true).setAttribute("login", l);
			if(e!=null){
				request.getSession(false).setAttribute("employee", e);
			}
			RequestDispatcher rd=request.getRequestDispatcher("Login_Success.jsp");
			rd.forward(request, response);
			}
		else{
			request.setAttribute("error", "Error");
			RequestDispatcher rd=request.getRequestDispatcher("loginEmp.jsp");
			rd.forward(request, response);
		}
		}else{
			request.setAttribute("error", "Error");
			RequestDispatcher rd=request.getRequestDispatcher("loginEmp.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
