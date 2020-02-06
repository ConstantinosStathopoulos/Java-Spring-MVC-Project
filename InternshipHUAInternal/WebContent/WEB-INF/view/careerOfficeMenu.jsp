
<!DOCTYPE html>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>OfficeMenu</title>
   </head>

   <body>
   		
      <h2>For student managment</h2>
      <form:form method = "GET" action = "list">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Manage Students"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "GET" action = "Manage_Positions">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Manage Positions"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "GET" action = "Accepted_Positions">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Accepted Positions List"/>
               </td>
            </tr>
         </table>  
      </form:form>
      
    
   </body>
</html>

