<!DOCTYPE html>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Student Menu</title>
   </head>

   <body>
      <h2>You are allowed to make a request</h2>
      
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
