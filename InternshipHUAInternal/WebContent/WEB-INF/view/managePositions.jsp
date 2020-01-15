<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/listview.css" />
<body>
<form action="servlet" method ="post"></form>
        <div id="wrapper">
                <div id="header">
                        <h2>POSITIONS FOR INTERNSHIPS MANAGMENT</h2>
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
                                        <th>Department</th>
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