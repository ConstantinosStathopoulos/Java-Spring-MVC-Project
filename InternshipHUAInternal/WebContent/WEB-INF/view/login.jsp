<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css" />
<style>
body {
background-color: #e6f2ff;
}
</style>

<title>Login Page</title>
<link rel="stylesheet" href="WebContent/resources/css/login.css">
</head>
<body>
  <center> 
		<div class="w3-panel w3-blue-grey">
<!-- 			<img src="resources/images/logo.png" alt="Χαροκόπειο Πανεπιστήμιο"> -->
			<h1 id="banner">Fill the form to Login to our system</h1>
		</div>
		<form:form action="${pageContext.request.contextPath}/authUser"
			method="POST">
			

			<!-- <div class="w3-panel w3-blue-gray"> -->

			<div class="field">
				<p style="color: red;">
					<label>Username</label> <input type="text" name="username" />
				</p>
			</div>
			<div class="field">
				<p style="color: red;">
					<label>Password</label> <input type="password" name="password" />
				</p>
			</div>
			<div class="field">
				<input type="submit" value="Login" />
			</div>
			
			<p style="color: red;">
				<c:if test="${param.error != null}">
					<i>Sorry! Invalid username/password!</i>
				</c:if>
			</p>
		</form:form>
	
</body>
</html>