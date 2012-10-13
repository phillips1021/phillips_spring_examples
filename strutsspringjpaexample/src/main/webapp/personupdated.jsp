<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Updated</title>
</head>
<body>
<h3>Below are the details of the person updated.</h3>

<s:if test="person != null" >

        
             
	<p><s:property value="person" />  </p>



</s:if>

<s:else>

<p>No person was found to update.</p>
</s:else>

<p><a href="index.jsp">Find another employee</a></p>
<p><a href="<s:url action='allPersonsFinder'/>">Find all employees</a>.</p>


</body>
</html>