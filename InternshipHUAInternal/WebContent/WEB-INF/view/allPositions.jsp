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
                                        <tr>
                                        		<td>${tempPositions.id}</td>
                                        		<td>${tempPositions.name}</td>
                                                <td>${tempPositions.subject}</td>
                                                <td><input type="checkbox"> </td>
                                                <td>
                                        		<select name="Department">
                                        			<option>Informatics</option>
                                        			<option>Geography</option>
                                        			<option>Nutrition</option>
                                        			<option>Home Economics</option>
                                        		</select>
                                        		</td>
                                        </tr>
                                </c:forEach>
                        </table>
                </div>
        </div>
</body>
</html>