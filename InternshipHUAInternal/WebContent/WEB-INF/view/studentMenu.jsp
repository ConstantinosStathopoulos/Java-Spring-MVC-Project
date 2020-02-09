<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
   <head>
   <style>
body {
  background-color:#e6f2ff;
  }
</style>
      <title>Student Menu</title>
   </head>

   <body>
   <center>
    <div class="w3-panel w3-blue-gray">
      <form:form method = "GET" action = "Internship_Request">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Make request for Internship"/>
               </td>
            </tr>
         </table>  
      </form:form>
      </div>
   </body>

</html>
