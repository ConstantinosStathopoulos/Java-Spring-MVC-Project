<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Σύστημα Πρακτικής Άσκησης</title>

</head>
<body>
	<img src="resources/images/logo.png" >
	<h1>Εσωτερικό Σύστημα Πρακτικής Άσκησης</h1>
	
	<h2>Login</h2>
      <form:form method = "GET" action = "login">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Login"/>
               </td>
            </tr>
         </table>  
      </form:form>
	
</body>
</html>