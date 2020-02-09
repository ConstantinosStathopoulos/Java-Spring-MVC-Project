
<!DOCTYPE html>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link type="text/css" rel="stylesheet">
<style>
body {
  background-color:#e6f2ff;
  
}
</style>

      <title>OfficeMenu</title>
   </head>
   

   <body>
 <center>

   		<div class="w3-panel w3-blue-gray">
	<img alt="" src="resources/images/logo.png">
      <h2>Student managment </h2>
   </div>
   <div class="w3-panel w3-dark-blue">
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
      </div>
<!--     </center> -->
   </body>
</html>
