<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<style>
body {
  background-color:#e6f2ff;
  }
</style>
<head>
<!--<meta charset="ISO-8859-1">-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Σύστημα Πρακτικής Άσκησης</title>

</head>
<body>
<center>
 <div class="w3-panel w3-blue-gray">
	
	<h1>Εσωτερικό Σύστημα Πρακτικής Άσκησης</h1>
	</div>
<!-- 	<div class="w3-panel w3-pale-blue"> -->
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
	</div>
</body>
</html>