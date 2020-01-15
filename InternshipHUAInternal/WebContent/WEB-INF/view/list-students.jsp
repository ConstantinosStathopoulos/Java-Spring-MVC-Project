
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>List Students</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/listview.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Managment System</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Lessons</th>
					<th>Year</th>
					<th>Average</th>
					<th>Allow</th>
				</tr>
				<!-- loop over and print our students -->
				<c:forEach var="tempStudents" items="${students}">
					<form action="updateStudentAccess" method="GET">
						<tr>
							<td>${tempStudents.id}</td>
							<td>${tempStudents.name}</td>
							<td>${tempStudents.surname}</td>
							<td>${tempStudents.lessons}</td>
							<td>${tempStudents.year}</td>
							<td>${tempStudents.average}</td>
							<td><input type="hidden" value="${tempStudents.id}" name="CurrentUpdate">
							<input type="submit" value="Grand Access"></td>
						</tr>
					
					</form>
				</c:forEach>
			
			</table>
				
		</div>

	</div>
	<h2>Button to return to home (for Career Office user home)</h2>
	<form:form method="GET" action="redirectHome">
		<table>
			<tr>
				<td><input type="submit" value="Back to home" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>