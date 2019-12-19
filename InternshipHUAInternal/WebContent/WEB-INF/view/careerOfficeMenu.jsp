
<!DOCTYPE html>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>CareerOffice Menu</title>
   </head>

   <body>
      <h2>For student managment</h2>
      <form:form method = "GET" action = "list">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "See Student List"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "GET" action = "All_Positions">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "See All Positions List"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "GET" action = "Accepted_Positions">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "See Accepted Positions List"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>

