<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Health Insurance</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body id="top">
	<% if(session.getAttribute("set")!=null){
		response.sendRedirect("TPA_Login_Success.jsp");
	}else if(session.getAttribute("login")!=null){
		response.sendRedirect("Login_Success.jsp");
	}else{
		%>
		<%@ include file="header.jsp" %>
		<%@ include file="content1.jsp" %>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<h1>Buy Group Health Insurance at EHI</h1>
				<p class="paragraph">Group health insurance is a medical insurance that covers a group of people,who are usually the members of societies,employee of a common company ,or professionals in a common group.
				Group health insurance helps companies identity and mitigate the risks faced by their employees.rising costs of health care have made it necessary for every employer to cover
				their employees and their families from financial instability that may arise in case of hospitalization.Also,group health insurance helps companies in attracting talented staff.
				Whether you are a small group or a company,you can easily retain best talent in the industry by offering comprehensive health insurance coverage.</p>
				
				
				<p class="paragraph">Almost all health insurance companies offer flexible covers at affordable rates,which depend on conglomeration of factors,like size of the group,profile of members,etc.It works under certain terms & conditions,which are applicable to all insured members.
				
				
				<h1>Benefits of Group Health Insurance policy</h1>
				<p class="paragraph">Employees are the treasured part of any organization.These days more and more companies are becoming employee centric and corporate health insurance has emerged as one of the most preferred benefits to lure new talent.It plays a crucial 
				role in influencing the psychology of an employee.It make him feel part of a company and thus,it curtails employee attrition rate and unrest in labor unions.Moreover,it increases their productivity which increases profitability of a business.
				Special insurance schemes where families are also covered for benefits make employees faithful towards their employers.Moreover,by offering coverage to your employees,you become eligible to get deductions under Income Tax act.
				So,group health insurance policy is a win-win situation for both employees and employers.</p>
				
				<h1>Feature Employee Health Insurance</h1>
				<p class="paragraph">There are several group health insurance policies available in the market.Listed below are some features present in all employee Health insurance plans</a></p>
				<ul>
					<li>Employee health insurance companies typically cover medical benefits for insured(self),spouse,children and dependent parents.</li>
					<li>Some health insurance [providers cover pre-existing illness and maternity as well.</li>
					<li>Employee health insurance offers Cash less hospitalization at network hospitals.</li>
					<li>Group health insurance can cover ancillary charges such as ambulance costs too. </li>
					<li>Some employee health insurance policies provide fee reimbursements of specialities and other practitionars for fellow check up .</li>
				</ul>
			</div>
		</div>
	</div>
	<%} %>
	<%@ include file="footer.jsp" %>
</body>
</html>