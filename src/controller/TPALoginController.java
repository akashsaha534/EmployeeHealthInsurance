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
 * Servlet implementation class TPALoginController
 */
public class TPALoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TPALoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String pass=request.getParameter("pass");
		TPAService ts=new TPAService();
		String password=ts.searchTPA(id);
		if(password!=null){
			if(pass.equals(password)){
			request.getSession(true).setAttribute("set", id);
			RequestDispatcher rd=request.getRequestDispatcher("TPA_Login_Success.jsp");
			rd.forward(request, response);
			}
		else{
			request.setAttribute("error", "Error");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		}else{
			request.setAttribute("error", "Error");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
