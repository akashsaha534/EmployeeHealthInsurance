package controller;
import beans.Login;

import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Label;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * Servlet implementation class GenerateCard
 */
public class GenerateCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletOutputStream sOut;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("did")!=null){
			int did=Integer.parseInt(request.getParameter("did"));
			UserService us=new UserService();
			String[] result=us.generateCardDep(did);
			sOut = response.getOutputStream();
	        // Create a document and set it's properties
	        Document objDocument = new Document();
	        // Create a page to add to the document
	        Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT, 54.0f);
	        // Create a Label to add to the page
	        String strText = "                    E-CARD"+"\n.............................................................."+"\nPolicy No: "+result[0]+"\nBeneficiary Name: "+result[1]+"\nHealth Insurance Id: "+result[2]+"\nEmployee Code: "+result[3]+"\nRelation: "+result[4]+"\nDate of Birth: "+result[5]+"\nPrimary Insured: "+result[6]+"\n..............................................................";
	        String text="Emergency Helpline No: 18001200300";
	        Label objLabel = new Label(strText, 0, 0, 300, 190, Font.getHelvetica(),15, TextAlign.LEFT);
	        Label objLabel1 = new Label(text, 0, 158, 300, 200, Font.getHelvetica(),8, TextAlign.LEFT);
	        // Add label to page
	        objPage.getElements().add(objLabel);
	        objPage.getElements().add(objLabel1);
	        // Add page to document
	        objDocument.getPages().add(objPage);
	        // Outputs the document to current web page.
	        objDocument.drawToWeb(request, response , sOut, "Dependent_E-Card_"+did+".pdf");
	        sOut.close();
		}else if(request.getSession(false).getAttribute("login")!=null){
				Login l=(Login)request.getSession(false).getAttribute("login");
				UserService us=new UserService();
				String[] result=us.generateCardEmp(l.getEmpId());
				sOut = response.getOutputStream();
		        // Create a document and set it's properties
		        Document objDocument = new Document();
		        // Create a page to add to the document
		        Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT, 54.0f);
		        // Create a Label to add to the page
		        String strText = "                    E-CARD"+"\n.............................................................."+"\nPolicy No: "+result[0]+"\nBeneficiary Name: "+result[1]+"\nHealth Insurance Id: "+result[2]+"\nEmployee Code: "+result[3]+"\nRelation: "+result[4]+"\nDate of Birth: "+result[5]+"\nPrimary Insured: "+result[6]+"\n..............................................................";
		        String text="Emergency Helpline No: 18001200300";
		        Label objLabel = new Label(strText, 0, 0, 300, 190, Font.getHelvetica(),15, TextAlign.LEFT);
		        Label objLabel1 = new Label(text, 0, 158, 300, 200, Font.getHelvetica(),8, TextAlign.LEFT);
		        // Add label to page
		        objPage.getElements().add(objLabel);
		        objPage.getElements().add(objLabel1);
		        // Add page to document
		        objDocument.getPages().add(objPage);
		        // Outputs the document to current web page.
		        objDocument.drawToWeb(request, response , sOut, "Employee_E-Card_"+l.getEmpId()+".pdf");
		        sOut.close();
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
