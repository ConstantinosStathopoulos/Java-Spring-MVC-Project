<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/listview.css" />
</head>
<body>
	<form action="update" method="post"></form>
	<div id="wrapper">
		<div id="header">
			<h2>List of available positions for Internship</h2>
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
					<th>Interest</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempPositions" items="${positions}">
				<form action="applyForPosition" method="GET">
					<tr>
						<td>${tempPositions.id}</td>
						<td>${tempPositions.name}</td>
						<td>${tempPositions.category}</td>
						<td><input type="hidden" value="${tempPositions.id}"
							name="CurrentUpdate"> <input type="submit"
							value="Apply"></td>
					</tr>
					</form>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>