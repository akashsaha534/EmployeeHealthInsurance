<%@page import="beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Bitter'
	rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="javascript/valid.js" ></script>
<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body id="top">
<% if(session.getAttribute("login")!=null){ 
Login login=(Login)session.getAttribute("login");
%>
	<%@ include file="headerEmp.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
			<% if(session.getAttribute("employee")!=null){%>
			<center><h2>You have already registered for health insurance scheme.</h2></center>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<% }else if(request.getAttribute("hid")!=null){
				int h=Integer.parseInt(request.getAttribute("hid").toString());
			if(h>0){%>
			<center><h2>You have succesfully registered for health insurance scheme.</h2></center>
			<center><h2>Your health insurance id is: <%=request.getAttribute("hid") %></h2></center>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<% }else{%>
				<center><h2>Error in registration</h2></center>
			<% }}else{ %>
				<div class="form-style-10">
					<h1>
						EHI Registration Form<span>Add your Details here</span>
					</h1>
					<form  name="Employeeform" action="AddEmployee" onsubmit="return validationform()">
						<p align="right">
							Fields marked with asterisk(<span style="color: red">*</span>)are
							mandatory
						</p>
						<div class="section">
							<span>1</span>Employee Id &amp; Name
						</div>
						<div class="inner-wrap">
							<label>Employee Id <input type="text" name="EmpId" value="<%=login.getEmpId() %>" readonly="readonly"/></label> 
							<label>Employee Name<span style="color: red">*</span>
								<select id="prefix" class="select" name="prefix" onchange="validategenderemp()">
						        <option value="Mr.">Mr.</option>
						        <option value="Mrs.">Mrs.</option>
						        <option value="Miss.">Miss.</option></select>
        <input type="text" class="eName" name="EmpName" id="eName" onblur="validateName()" onfocus="true"></label>
							<label id="nameerror"></label>
						</div>
						<div class="section">
							<span>2</span>Date Of Birth &amp; Gender
						</div>
						<div class="inner-wrap">
							<label>Date of Birth <span style="color: red">*</span><input type="date" name="DOB" id="dob" onblur="validatedob()" ></label><label id="doberror"></label>
								 <label>Gender<span
								style="color: red">*</span> 
								<input type="radio" id="male" name="gender" value="male" onclick="return false;" checked />Male 
								<input type="radio" id="female" name="gender" value="female" onclick="return false;"/>Female
							</label><label id="gerror"></label>

						</div>
						<div class="section">
							<span>3</span>Email Details
						</div>
						<div class="inner-wrap">
							<label>Email<span style="color: red">*</span><input type="text" name="EmailId" id="eId" onblur="validateEmail()" onfocus="true"></label>
							<label id="emailerror"></label> <label>Alternate Email<input type="text" name="alternateEmail" id="aId" onblur="validateAlternateEmail()" onfocus="true"/></label>
							<label id="email2error"></label>
						</div>

						<div class="section">
							<span>4</span>Phone Deatils
						</div>
						<div class="inner-wrap">
							<label>Phone number<span style="color: red">*</span><input type="text" name="Phone" id="pno" onblur="validatePhoneNo()" onfocus="true"/></label><label id="perror"></label> 
							<label>Alternate Number<input type="text" name="aPhone" id="apno" onblur="validateAlternatePhoneNo()" onfocus="true"/></label><label id="aperror"></label>
						</div>

						<div class="section">
							<span>5</span>Policy Details
						</div>
						<div class="inner-wrap">
							<label>Policy Start Date<span style="color: red">*</span>
								<input type="date" name="policydate" id="pd" onblur="validatepolicydate()"/></label><label id="pderror"></label> 
								<label>Policy period<span style="color: red">*</span><input type="text" name="policyPeriod" id="ppr" onblur="validatePolicyPeriod()" onfocus="true"/></label><label id="pperror"></label> 
								<label>Total sum Insured<span style="color: red">*</span><input type="text" name="totalSum" id="tSum" onblur="calculatePremium()" onfocus="true"/></label><label id="terror"></label> 
								<label>Premium amount<span
								style="color: red">*</span><input type="text" name="premiumAmmount" value="0" readonly="readonly" /></label>
						</div>

						<div class="section">
							<span>6</span>Bank Details
						</div>
						<div class="inner-wrap">
							<label>Bank Account Number<span style="color: red">*</span>
								<input type="text" name="accno" id="ano" onblur="validateBankAccountNo()" onfocus="true" /></label><label id="anoerror"></label> 
								<label>Name Of The
								Bank <span style="color: red">*</span><input type="text" name="nameOfBank" onblur="validateBank()" onfocus="true"></label><label id="berror">
							</label> <label>IFSC code<span style="color: red">*</span><input type="text" name="ifsc" onblur="validateIFSC()" onfocus="true" /></label><label id="cerror"></label>
						
						     <span class="privacy-policy" style="padding-left: 5px;">
     <input type="checkbox" name="checkbox" onblur="validatecheckbox()" onfocus="true"/>You agree to our Terms and Policy.<span style="color: red">*</span> 
    
     </span><br></div>

						<div class="button-section">
     <input type="submit" name="Sign Up"/>

    </div>
					</form>
					
				</div>
			<%} %>


			</div>
		</div>
	</div>
	<%}else{response.sendRedirect("loginEmp.jsp");} %>
	<%@ include file="footer2.jsp"%>
	
	
	
</body>
</html>