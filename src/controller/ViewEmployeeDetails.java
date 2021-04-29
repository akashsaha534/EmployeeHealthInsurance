package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

import beans.Bank;
import beans.Employee;
import beans.Health_Insurance;
import beans.Login;
import beans.Policy;
import beans.Request;
import dao.UserDAO;

/**
 * Servlet implementation class ViewEmployeeDetails
 */
public class ViewEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession(false).getAttribute("login")!=null){
			if(request.getSession(false).getAttribute("employee")==null){
				RequestDispatcher rd=request.getRequestDispatcher("ViewEmployeeDetails.jsp");
				rd.forward(request, response);
			}else{
		Login l=(Login)request.getSession(false).getAttribute("login");
		UserService us=new UserService();
		Employee e=us.viewEmployeeDetails(l.getEmpId());
		Bank b=us.viewBankDetails(e.getEmpId());
		Health_Insurance h=us.viewHealthInsuranceDetailsForEmployee(e.getEmpId());
		Policy p=us.viewPolicyDetails(h.getPolicy_No());
		request.setAttribute("employee", e);
		request.setAttribute("bank", b);
		request.setAttribute("health", h);
		request.setAttribute("policy", p);
		RequestDispatcher rd=request.getRequestDispatcher("ViewEmployeeDetails.jsp");
		rd.forward(request, response);
		}}
		else if(request.getSession(false).getAttribute("set")!=null){
			int Empid=Integer.parseInt(request.getParameter("empid"));
			int reqid=Integer.parseInt(request.getParameter("reqid"));
			int hid=Integer.parseInt(request.getParameter("hid"));
			String status=request.getParameter("status");
			UserService us=new UserService();
			Employee e=us.viewEmployeeDetails(Empid);
			Bank b=us.viewBankDetails(Empid);
			Health_Insurance h=us.viewHealthInsuranceDetailsForEmployee(e.getEmpId());
			Policy p=us.viewPolicyDetails(h.getPolicy_No());
			request.setAttribute("employee", e);
			request.setAttribute("bank", b);
			request.setAttribute("health", h);
			request.setAttribute("policy", p);
			request.setAttribute("reqid", reqid);
			request.setAttribute("status", status);
			request.setAttribute("hid", hid);
			RequestDispatcher rd=request.getRequestDispatcher("ViewEmployeeDetails.jsp");
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
