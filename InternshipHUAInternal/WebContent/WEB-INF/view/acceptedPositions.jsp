
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-color:#e6f2ff;
  }
</style>
        <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<title>List Customers</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/listview.css" />
</head>
<body>
    <center> 

                <div class="w3-panel w3-blue-gray">
   
   
<form action="update" method="post"></form>
        <div id="wrapper">
                <div id="header">
                        <h2>Positions for Interships</h2>
                </div>
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
                                        <tr>
                                        		<td>${tempPositions.id}</td>
                                        		<td>${tempPositions.name}</td>
                                                <td>${tempPositions.category}</td>
                                                <td>${tempPositions.department}</td>
                                        </tr>
                                </c:forEach>
                        </table>
                </div>
        </div>


</body>
</html>