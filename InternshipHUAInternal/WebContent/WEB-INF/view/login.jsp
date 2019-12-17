<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
	<img src="https://www.hua.gr/files/logo@2x.png" alt="Χαροκόπειο Πανεπιστήμιο">
	<head>
	<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/login.css" />
	<title>Login Page</title>
	<link rel="stylesheet" href="WebContent/css/login.css">
	</head>
    <body>
        <h1 id="banner">Login to Security Demo</h1>  
        <form name="f" action="<c:url value='j_spring_security_check'/>"
                    method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type='text' name='username' /></td>
                </tr>
                <tr>
                    <td><br>Password:</td>
                    <td><br><input type='password' name='password'></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>