package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TPAService;
import service.UserService;
import beans.Login;
import beans.Request;

/**
 * Servlet implementation class ViewPendingRequest
 */
public class ViewRequestList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewRequestList() {
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
			ArrayList<Request> rlist=us.viewRequestLists(l.getEmpId());
			request.setAttribute("RequestList", rlist);
				RequestDispatcher rd=request.getRequestDispatcher("User_View_Request.jsp");
				rd.forward(request, response);
		}else if(request.getParameter("status")!=null){
			String action=request.getParameter("status");
			TPAService tps=new TPAService();
			ArrayList<Request> rlist=null;
			if(action.equals("Approved")){
				rlist=tps.viewRequestList(action);
			}
			if(action.equals("Rejected")){
				rlist=tps.viewRequestList(action);
			}
			if(action.equals("Pending")){
				rlist=tps.viewRequestList(action);
				for(Request r:rlist){
					double diff=tps.getDifference(r.getSubmitDate());
					if(diff>48){
						tps.updateSLA(r);
					}
				}
			}
			request.setAttribute("status", action);
			request.setAttribute("RequestList", rlist);
			RequestDispatcher rd=request.getRequestDispatcher("TPA_View_Request.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("home.jsp");
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
