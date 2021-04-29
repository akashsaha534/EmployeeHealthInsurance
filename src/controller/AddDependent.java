package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

import dao.UserDAO;

/**
 * Servlet implementation class AddDependent
 */
public class AddDependent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDependent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int EmpId=Integer.parseInt(request.getParameter("EmpId"));
		String BeneName=request.getParameter("EmpName");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-mm");
		Date DOB=null;
			try {
				DOB = sdf.parse(request.getParameter("DOB"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String Gender=request.getParameter("gender");
		String relation=request.getParameter("relation");
		Date StartDate=null;
		try {
			StartDate = sdf.parse(request.getParameter("policydate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Policy_Period=Integer.parseInt(request.getParameter("policyPeriod"));
		double Sum_Insured=Double.parseDouble(request.getParameter("totalSum"));
		double Premium_Amount=Double.parseDouble(request.getParameter("premiumAmmount"));
		UserService us=new UserService();
		int a=us.addDependent(EmpId, BeneName, DOB, Gender, relation, StartDate,Policy_Period,Sum_Insured,Premium_Amount);
		request.setAttribute("dep", a);
		RequestDispatcher rd=request.getRequestDispatcher("ViewDependentDetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
