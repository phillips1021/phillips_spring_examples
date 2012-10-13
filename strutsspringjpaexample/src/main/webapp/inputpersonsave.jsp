<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Person</title>
</head>
<body>
<h3>Use the form below to create a new employee.</h3>


     <s:form action="executePersonSave" method="post">
     
     	<s:textfield name="person.first_name" label="First name" />
     	<s:textfield name="person.last_name" label="Last name" />
     	
     	
     	
     	<s:submit />
     
     </s:form>



<p><a href="index.jsp">Find another employee</a></p>
<p><a href="<s:url action='allPersonsFinder'/>">Find all employees</a>.</p>


</body>
</html>