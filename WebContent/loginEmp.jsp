<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TPA login</title>
<link href='http://fonts.googleapis.com/css?family=Bitter'
	rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<div class="form-style-10">
					<h1>
						Login Form<span>Only Employee will login here</span>
					</h1>
					<%if(request.getAttribute("error")!=null){%>
					<h3 style="color:red">Invalid Employee Id / Password </h3><%} %>
					<form action="SearchEmployee" method="post">
			<p align="right">Fields marked with asterisk(<span style="color:red">*</span>)are mandatory</p>
						<div class="section">Employee Id &amp; Password</div>
						<div class="inner-wrap">
							<label>Employee Id <span style="color: red">*</span><input type="text" name="EmpId" required/></label> 
							<label>Password <span style="color: red">*</span><input type="password" name="password" required/></label>
						</div>
						<div class="button-section">
							<input type="submit" name="Login" />

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer2.jsp"%>
</body>
</html>