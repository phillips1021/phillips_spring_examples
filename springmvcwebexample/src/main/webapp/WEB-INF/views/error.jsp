<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Spring MVC Web Example Error Page</title>
</head>
<body>
	<h1>Welcome to Spring MVC Web Example Error Page</h1>
	
    <p>Failed URL: ${url}</p>
    <p>Exception:  ${exception.message} <br />
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} <br />
    </c:forEach>

</body>

</html>