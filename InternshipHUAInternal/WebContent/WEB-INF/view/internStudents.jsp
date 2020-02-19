<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/listview.css" />
	<style>
body {
  background-color:#e6f2ff;
  
}
</style>
</head>
<body>
<center>
	<form action="update" method="post"></form>
	<div id="wrapper">
		<div id="header">
			<h2>Students Chosen For Internships</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Subject</th>
					<th>Student</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempPositions" items="${positions}">
				
					<tr>
						<td>${tempPositions.id}</td>
						<td>${tempPositions.name}</td>
						<td>${tempPositions.category}</td>
						<td>${tempPositions.chosen_student}</td>
					</tr>
					</form>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>