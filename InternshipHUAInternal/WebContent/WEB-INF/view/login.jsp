<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
	<img src="https://www.hua.gr/files/logo@2x.png" alt="Χαροκόπειο Πανεπιστήμιο">
	<head>
	<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/login.css" />
	<title>Login Page</title>
	<link rel="stylesheet" href="WebContent/resources/css/login.css">
	</head>
    <body>
        <h1 id="banner">Login to Security Demo</h1>  
        <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
        <c:if test="${param.error != null}">
                <i>Sorry! Invalid username/password!</i>
        </c:if>
        <div class="field">
                        <label>User Name</label>
                        <input type="text" name="username"/>
                </div>
                <div class="field">
                        <label>Password</label>
                        <input type="password" name="password"/>
                </div>
                <div class="field">
                                <input type="submit" value="Login" />
                        </div>
        </form:form>
    </body>
</html>