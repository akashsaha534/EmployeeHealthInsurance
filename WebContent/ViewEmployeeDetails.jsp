<%@page import="beans.Policy"%>
<%@page import="beans.Health_Insurance"%>
<%@page import="beans.Bank"%>
<%@page import="beans.Employee"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Request Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/details.css" type="text/css">
</head>
<body>

<% if(session.getAttribute("login")!=null){%>
	<%@ include file="headerEmp.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
			
				 
				   	<%if(session.getAttribute("employee")==null){ %>
					<center><h2>Details not found... </h2></center>
					<center><h2>At first register for health insurance </h2></center>
					<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					<%}else{ %>
					<% Employee emp=(Employee)request.getAttribute("employee"); %>
				<h2><a href="GenerateCard">Generate E-Card for Health Insurance</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="ViewDependentDetails?empid=<%=emp.getEmpId() %>">View Dependent Details</a></h2>
				<br><br><br>
					<div class="details">
					<center><table class="table1" border="1"  cellpadding="8">
					<tr><th colspan="2"><center>Employee Details</center></th></tr>
					<tr>
					<td>Employee Id: </td>
					<td><%=emp.getEmpId() %></td>
					</tr>
					<tr>
					<td>Employee Name: </td>
					<td><%=emp.getEmpName() %></td>
					</tr>
					<tr>
					<td>Date of Birth: </td>
					<% 
					String date_s = emp.getDOB().toString(); 
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
					Date date = dt.parse(date_s); 
					SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
					%>
					<td><%=dt1.format(date) %></td>
					</tr>
					<tr>
					<td>Gender: </td>
					<td><%=emp.getGender() %></td>
					</tr>
					<tr>
					<td>Phone No: </td>
					<td><%=emp.getPhoneNo() %></td>
					</tr>
					<tr>
					<td>Alternate Phone No: </td>
					<% if(emp.getAlternate_PhoneNo()>0){%><td><%=emp.getAlternate_PhoneNo() %></td>
					<% }else{%><td>-</td><%} %>
					</tr>
					<tr>
					<td>Email: </td>
					<td><%=emp.getEmail() %></td>
					</tr>
					<tr>
					<td>Alternate Email: </td>
					<% if(emp.getAlternate_Email()!=null){%><td><%=emp.getAlternate_Email() %></td>
					<% }else{%><td>-</td><%} %>
					</tr>
					</table></center></div>
					<br><br><br><br><br>
					<div class="details">
					<% Bank b=(Bank)request.getAttribute("bank"); %>
					<center><table class="table2" border="1"  width="310px" height="355px" cellpadding="24">
					<tr><th colspan="2"><center>Bank Details</center></th></tr>
					<tr>
					<td>Account Number: </td>
					<td><%=b.getAccNo() %></td>
					</tr>
					<tr>
					<td>Bank Name: </td>
					<td><%=b.getBankName() %></td>
					</tr>
					<tr>
					<td>IFSC Code: </td>
					<td><%=b.getIFSC() %></td>
					</tr>
					</table></center>
					</div>
					<br><br><br><br><br>
					<% Policy p=(Policy)request.getAttribute("policy"); %>
					<center><table class="table3" border="1"  cellpadding="27" >
					<tr><th colspan="2"><center>Policy Details</center></th></tr>
					<tr>
					<td>Policy Number: </td>
					<td><%=p.getPolicy_No() %></td>
					</tr>
					<tr>
					<td>Policy Period: </td>
					<td><%=p.getPolicy_Period() %></td>
					</tr>
					<tr>
					<td>Sum Insured: </td>
					<td><%=p.getSum_Insured() %> INR</td>
					</tr>
					<tr>
					<td>Premium Amount: </td>
					<td><%=p.getPremium_Amount() %> INR</td>
					</tr>
					</table></center>
					<br><br><br><br><br>
					<% Health_Insurance h=(Health_Insurance)request.getAttribute("health"); %>
					<center><table class="table3" border="1" height="300px" width="300px"cellpadding="6" >
					<tr><th colspan="2"><center>Health Insurance Details</center></th></tr>
					<tr>
					<td>Health Insurance Id: </td>
					<td><%=h.getHID() %></td>
					</tr>
					<tr>
					<td>Policy No: </td>
					<td><%=h.getPolicy_No() %></td>
					</tr>
					<tr>
					<td>Status: </td>
					<td><%=h.getStatus() %></td>
					</tr>
					</table></center>
					<br><br><br><br><br>
					
					<%}}else if(session.getAttribute("set")!=null){%>

						<%@ include file="header2.jsp"%>
							<div class="wrapper col4">
								<div class="container">
									<div class="content">
										<br><br><br>
					<%Employee emp=(Employee)request.getAttribute("employee"); %>
					<center><table border="1" height="100" width="400" cellpadding="10" >
					<tr><th colspan="2"><center>Employee Details</center></th></tr>
					<tr>
					<td>Employee Id: </td>
					<td><%=emp.getEmpId() %></td>
					</tr>
					<tr>
					<td>Employee Name: </td>
					<td><%=emp.getEmpName() %></td>
					</tr>
					<tr>
					<td>Date of Birth: </td>
					<% 
					String date_s = emp.getDOB().toString(); 
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
					Date date = dt.parse(date_s); 
					SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
					%>
					<td><%=dt1.format(date) %></td>
					</tr>
					<tr>
					<td>Gender: </td>
					<td><%=emp.getGender() %></td>
					</tr>
					<tr>
					<td>Phone No: </td>
					<td><%=emp.getPhoneNo() %></td>
					</tr>
					<tr>
					<td>Alternate Phone No: </td>
					<% if(emp.getAlternate_PhoneNo()>0){%><td><%=emp.getAlternate_PhoneNo() %></td>
					<% }else{%><td>-</td><%} %>
					</tr>
					<tr>
					<td>Email: </td>
					<td><%=emp.getEmail() %></td>
					</tr>
					<tr>
					<td>Alternate Email: </td>
					<% if(emp.getAlternate_Email()!=null){%><td><%=emp.getAlternate_Email() %></td>
					<% }else{%><td>-</td><%} %>
					</tr>
					</table></center>
					<% Bank b=(Bank)request.getAttribute("bank"); %>
					<br><br><br>
					<center><table border="1" height="100" width="400" cellpadding="10">
					<tr><th colspan="2"><center>Bank Details</center></th></tr>
					<tr>
					<td>Account No: </td>
					<td><%=b.getAccNo() %></td>
					</tr>
					<tr>
					<td>Bank Name: </td>
					<td><%=b.getBankName() %></td>
					</tr>
					<tr>
					<td>IFSC Code: </td>
					<td><%=b.getIFSC() %></td>
					</tr>
					</table></center>
					<br><br><br>
					<% Health_Insurance h=(Health_Insurance)request.getAttribute("health"); %>
					<center><table border="1" height="100" width="400" cellpadding="10">
					<tr><th colspan="2"><center>Health Insurance Details</center></th></tr>
					<tr>
					<td>Health Insurance Id: </td>
					<td><%=h.getHID() %></td>
					</tr>
					<tr>
					<td>Policy No: </td>
					<td><%=h.getPolicy_No() %></td>
					</tr>
					<tr>
					<td>Status: </td>
					<td><%=h.getStatus() %></td>
					</tr>
					</table></center>
					<br><br><br>
					<% Policy p=(Policy)request.getAttribute("policy"); %>
					<center><table border="1" height="100" width="400" cellpadding="10">
					<tr><th colspan="2"><center>Policy Details</center></th></tr>
					<tr>
					<td>Policy No: </td>
					<td><%=p.getPolicy_No() %></td>
					</tr>
					<tr>
					<td>Policy Period(in Years): </td>
					<td><%=p.getPolicy_Period() %></td>
					</tr>
					<tr>
					<td>Sum Insured: </td>
					<td><%=(int)p.getSum_Insured() %> INR</td>
					</tr>
					<tr>
					<td>Premium Amount: </td>
					<td><%=(int)p.getPremium_Amount() %> INR</td>
					</tr>
					</table></center>
					<br><br><br>
					<% String action=request.getAttribute("status").toString();
					int hid=Integer.parseInt(request.getAttribute("hid").toString());
					if(action.equals("Pending")){
					%>
					<a href="DecisionController?hid=<%=hid %>&reqid=<%=request.getAttribute("reqid") %>&decision=Approved" onclick="return confirm('Are you sure?')"><center><h3>Click here to Approve</h3></center></a>
					<a href="DecisionController?hid=<%=hid %>&reqid=<%=request.getAttribute("reqid") %>&decision=Rejected" onclick="return confirm('Are you sure?')"><center><h3>Click here to Reject  </h3></center></a>
					<%} 
					if(action.equals("Rejected")){
					%>
					<a href="DecisionController?hid=<%=hid %>&reqid=<%=request.getAttribute("reqid") %>&decision=Approved" onclick="return confirm('Are you sure?')"><center><h3>Click here to Approve</h3></center></a>
					<%} %>
					<br><br><br>
					<%}else{
						response.sendRedirect("home.jsp");
					}
						%>
						<button type="button" name="back" onclick="history.back()">Back</button>
						</div>
					</div>
					</div>
						
			<%@ include file="footer2.jsp"%>
</body>
</html>