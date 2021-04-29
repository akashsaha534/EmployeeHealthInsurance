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
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int EmpId=Integer.parseInt(request.getParameter("EmpId"));
		String EmpName=request.getParameter("EmpName");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-mm");
		Date DOB=null;
			try {
				DOB = sdf.parse(request.getParameter("DOB"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String Gender=request.getParameter("gender");
		String Email=request.getParameter("EmailId");
		String Alternate_Email=null;
		if(request.getParameter("alternateEmail")!=null){
			Alternate_Email=request.getParameter("alternateEmail");
		}
		long PhoneNo=Long.parseLong(request.getParameter("Phone"));
		long Alternate_PhoneNo=0;
		if(request.getParameter("aPhone")==null){
			Alternate_PhoneNo=Long.parseLong(request.getParameter("aPhone"));
		}
		long AccNo=Long.parseLong(request.getParameter("accno"));
		String BankName=request.getParameter("nameOfBank");
		String IFSC=request.getParameter("ifsc");
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
		int hid=0;
		hid=us.addEmployee(EmpId, EmpName, DOB, Gender, Email, Alternate_Email, PhoneNo, Alternate_PhoneNo,StartDate,Policy_Period,Sum_Insured,Premium_Amount,AccNo,BankName,IFSC);
		RequestDispatcher rd=request.getRequestDispatcher("empReg.jsp");
		request.setAttribute("hid", hid);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
