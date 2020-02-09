<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
body {
  background-color:#e6f2ff;
  
}
</style>
<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/listview.css" />
<body>
	<center>

                <div class="w3-panel w3-blue-gray">

<form action="servlet" method ="post"></form>
        <div id="wrapper">
                <div id="header">
                        <h2>Positions for Interships Managment </h2>
                </div>
        </div>

    </div>
<!--     <div class="w3-panel w3-blue-gray"> -->
        <div id="container">
                <div id="content">
                        <!--  add our html table here -->
                        <table>
                                <tr>
                                		<th>ID</th>
                                		<th>Name</th>
                                        <th>Subject</th>
                                        <th>Department</th>
                                        <th>Action</th>
                                </tr>
                                <!-- loop over and print our customers -->
                                <c:forEach var="tempPositions" items="${positions}">
	                                <form action="updatePositionAccess" method="GET">
	                                        <tr>
	                                        		<td>${tempPositions.id}</td>
	                                        		<td>${tempPositions.name}</td>
	                                                <td>${tempPositions.category}</td>
	                                                <td>
	                                        		<select name="Department">
	                                        			<option>Informatics</option>
	                                        			<option>Geography</option>
	                                        			<option>Nutrition</option>
	                                        			<option>Home Economics</option>
	                                        		</select>
	                                        		</td>
	                                        		<td><input type="hidden" value="${tempPositions.id}" name="CurrentUpdate">
	                                        		<input type="submit" value="Accept"></td>
	                                        </tr>
	                                 </form>
                                </c:forEach>
                        </table>
                </div>
        </div>
        
        
	<form:form method="GET" action="redirectHome">
		<table>
			<tr>
				<td><input type="submit" value="Back to home" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>