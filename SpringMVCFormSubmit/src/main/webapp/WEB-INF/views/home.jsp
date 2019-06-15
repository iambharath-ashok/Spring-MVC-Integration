<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="<c:url value='/employee/list'/>">Employee List</a>
<a href="<c:url value='employee/new'/>">Employee Registration</a>
</body>
</html>
