package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TPAService;

import dao.TPADao;

/**
 * Servlet implementation class DecisionController
 */
public class DecisionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DecisionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated mehod stub
		int hid=Integer.parseInt(request.getParameter("hid"));
		int reqid=Integer.parseInt(request.getParameter("reqid"));
		String decision=request.getParameter("decision");
		if(decision.equals("Approved")){
			TPAService ts=new TPAService();
			request.setAttribute("approved", reqid);
			ts.approveRequest(hid,reqid);
		}else if(decision.equals("Rejected")){
			TPAService ts=new TPAService();
			request.setAttribute("rejected", reqid);
			ts.rejectRequest(hid,reqid);
		}
		RequestDispatcher rd=request.getRequestDispatcher("TPA_Login_Success.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
