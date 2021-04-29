<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
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
	Login login=(Login)session.getAttribute("login");%>
	<%@ include file="headerEmp.jsp"%>
	<%if(session.getAttribute("employee")==null){
	%>


<div class="wrapper col4">
		<div class="container">
			<div class="content">
			<h2>At first register yourself for health insurance scheme</h2>
			<h2>After that you can add your dependent</h2>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<%}else{ %>
			<div class="form-style-10">
<h1>Dependent Form<span>Add your dependent here</span></h1>
<form  name="Employeeform" action="AddDependent" onsubmit="return validationformdep()">

				<p align="right">Fields marked with asterisk(<span style="color:red">*</span>)are mandatory</p>
    <div class="section"><span>1</span>Employee Id &amp; Beneficiary Name</div>
    <div class="inner-wrap">
        <label>Employee Id <input type="text" name="EmpId" value="<%=login.getEmpId() %>" readonly="readonly"/></label>
        <label>Beneficiary Name<span style="color:red">*</span><select id="prefix" class="select" name="prefix" onchange="validategender()">
      
        <option value="Mr.">Mr.</option>
        <option value="Mrs.">Mrs.</option>
        <option value="Miss.">Miss.</option></select>
         <input type="text" class="eName" name="EmpName" id="eName" onblur="validateName()" onfocus="true"></label>
							<label id="nameerror"></label>
    </div>

    <div class="section"><span>2</span>Relation &amp; Gender &amp; Date Of Birth</div>
    <div class="inner-wrap">
        <label>Relation<span style="color:red">*</span><select id="relation" onchange="validategender()" name="relation"  width="50px" >
		<option value="Father" width="50px" size="28" >Father</option>
	    <option value="Mother">Mother</option>
		<option value="Father-in-law">Father-in-law</option>
        <option value="Mother-in-law">Mother-in-law</option>
        <option value="Brother">Brother</option>
        <option value="Sister">Sister</option>						
								

						</select></label><label id="rerror"></label>
						 <label>Gender<span
								style="color: red">*</span> 
								<input type="radio" id="male" name="gender" value="Male" onclick="return false;" checked />Male 
								<input type="radio" id="female" name="gender" value="Female" onclick="return false;"/>Female
							</label>
        <label>Date of Birth <span style="color:red">*</span><input type="date" name="DOB" id="dob" onblur="validatedobr()" ></label><label id="doberror"></label>
    </div>

    <div class="section"><span>3</span>Policy</div>
        <div class="inner-wrap">
        <label>Policy Start Date<span style="color:red">*</span><input type="date" name="policydate" id="pd" onblur="validatepolicydate()" ></label><label id="pderror"></label>
        <label>Policy period <span style="color:red">*</span><input type="text" name="policyPeriod" id="ppr" onblur="validatePolicyPeriod()" onfocus="true"/></label><label id="pperror"></label> 
         <label>Total sum Insured<span style="color:red">*</span><input type="text" name="totalSum" id="tSum" onblur="calculatePremium()" onfocus="true"/></label><label id="terror"></label> 
        <label>Premium amount<span style="color:red">*</span><input type="text" name="premiumAmmount" value="0" readonly="readonly"/></label>
   
	<span class="privacy-policy">
     <input type="checkbox" name="checkbox" onblur="validatecheckbox()" onfocus="true"/>You agree to our Terms and Policy. 
    
     </span>
     <br>   
    </div>
    
    <div class="button-section">
     <input type="submit" name="Sign Up" />
     
    </div>
</form>
</div>
			
			
			
			
		
		<%}} else{response.sendRedirect("loginEmp.jsp");}%>
		</div>
			</div>
			</div>
		<%@ include file="footer2.jsp"%>	
</body>
</html>