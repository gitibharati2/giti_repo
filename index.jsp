<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> <center> SHOPPING CART </center></h2>


Existing User:<a href="login">Login Here</a>
New User:<a href="Register">Register Here</a>
<hr>
${successMessage}

<c:if test="${not empty errormessage}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedLogin}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedRegister}">
<jsp:include page="Register.jsp"></jsp:include>
</c:if>

</body>
</html>
