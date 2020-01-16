<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
   <head>
      <title>Student Menu</title>
   </head>

   <body>
   		<sec:authorize access="isAuthenticated()">
        <div class="ui segment">
        <h2>Welcome! You are logged in as <sec:authentication property="principal.username" /> </h2>
        <h2>enabled user:<sec:authentication property="principal.enabled" /></h2>
        </div>
</sec:authorize>
   		
      	
      	
      
      <form:form method = "GET" action = "Internship_Request">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Make request for Internship"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>
