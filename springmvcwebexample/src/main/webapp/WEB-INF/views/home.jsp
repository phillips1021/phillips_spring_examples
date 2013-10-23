<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Spring MVC Web Example Home Page</title>
</head>
<body>
	<h1>Welcome to Spring MVC Web Example Home Page</h1>
	
	<c:forEach items="${people}" var="person">
		<p>Person: <c:out value="${person.firstName}" /> <c:out value="${person.lastName}" /> </p>
		
	</c:forEach>

</body>

</html>