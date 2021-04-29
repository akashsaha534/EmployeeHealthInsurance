<%@page import="beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login Success Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" ></script>
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
<script type="text/javascript">
function checkPassword(){
	var old1=document.getElementById("old").value;
	var old2=document.getElementById("oldpass").value;
	if(old1!=old2){
		document.getElementById("error").innerHTML="Incorrect old password";
	   	document.getElementById("error").style.color="red";
		document.getElementById("error").style.fontFamily ="Times New Roman";
	}
	else{
		document.getElementById("error").innerHTML="";
	}
}
function validatepassword()
{
	
	var password=document.getElementById("newpass").value;
	var re =  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
//	var re1=/[0-9]/;
//	var re2=/[a-z]/;
//	var re3=/[A-Z]/;
	if(!re.test(password)  || password=="" || password==null || password.length<8 || password.length>15)
		{
		
	   	document.getElementById("passerror").innerHTML="Passwords must contain at least eight characters or utmost fifteen character, including uppercase[A-Z], lowercase[a-z] ,numbers[0-9] and special character";
	   	document.getElementById("passerror").style.color="red";
		document.getElementById("passerror").style.fontFamily ="Times New Roman";
	   	return password;
		}
	else
		{
		document.getElementById("passerror").innerHTML="";
	return password;
		}
	}
function toggle_password(target){
    var tag = document.getElementById(target);
    var tag2 = document.getElementById("showhide");
    if (tag2.innerHTML == 'Show'){
        tag.setAttribute('type', 'text');   
        tag2.innerHTML = 'Hide';
    }
    else{
        tag.setAttribute('type', 'password');   
        tag2.innerHTML = 'Show';
    }

    }
function validateconfirmpassword()
{
	
	var cpassword=document.getElementById("confpass").value;
	var password=document.getElementById("newpass").value;
	if(password!=cpassword || cpassword=="" || cpassword==null)
		{
		document.getElementById("cpasserror").style.color="red";
		document.getElementById("cpasserror").style.fontFamily ="Times New Roman";
	   	document.getElementById("cpasserror").innerHTML="password does not match.";
    	return false;
		}
	else
		{
		document.getElementById("cpasserror").innerHTML="";
		return true;
		}
		
	}
function myFunction() {
    var pass1 = document.getElementById("newpass").value;
    var pass2 = document.getElementById("confpass").value;
    if (pass1 != pass2) {
        alert("Passwords Do not match");
       
        return false;
    }
    else {
       return true;
    }
}
</script>
</head>
<body>
<% if(session.getAttribute("login")!=null){
	%>
	<%@ include file="headerEmp.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<br><br><br>
				<center>
				<%! int empid; %>
				<% if(request.getAttribute("login")!=null){
				Login l=(Login)request.getAttribute("login");
				empid=l.getEmpId();
				}else{
				 Login l=(Login)session.getAttribute("login"); %>
				<form action="ChangePassword" method="get"  onsubmit="myFunction()" >
				<input type="hidden" id="old" value="<%=l.getPassword() %>">
				<table border="1" height="100" width="400" cellpadding="10">
				<tr><th colspan="2"><center>Change Your Password</center></th></tr>
				<tr>
				<td>Employee Id: </td>
				<td><input type="text" name="eid" readonly="readonly" value="<%=l.getEmpId() %>"/></td>
				</tr>
				<tr>
				<td>Enter Old Password: </td>
				<td><input type="password" name="oldpass" id="oldpass" onblur="checkPassword()"/><p id="error"></p></td>
				
				</tr>
				<tr>
				<td>Enter New Password: </td><p for="newpass"></p>
				<td><input type="password" name="newpass"  id="newpass" onchange="validatepassword()" />
				<a href="#" onclick="toggle_password('newpass');" id="showhide">Show</a> <p id="passerror"></p></td>
				
				</tr>
				<tr>
				<td>Confirm New Password: </td>
				<td><input type="password" name="confpass" id="confpass" onchange="validateconfirmpassword()"/><p id="cpasserror"></p></td>
				
				</tr>
				<tr><td colspan="2"><center><input class="button" type="submit" value="Submit" name="submit" onclick="return myFunction()"/></center></td></tr>
				</table>
				</form>
				<%}}else{response.sendRedirect("loginEmp.jsp");} %>
				</center>
				<br><br><br><br>
			</div>
			</div>
		</div>
	</div>
<%@ include file="footer2.jsp"%>
</body>
</html>