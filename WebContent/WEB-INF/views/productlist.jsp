<%@page import="java.util.Iterator"%>
<%@page import="com.aprisma.latihan.model.Product"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Data Product</h1>
<table border=1 width=80%>
<tr>
	<th>Name</th>
	<th>Type</th>
</tr>

<c:forEach items="${listOfProduct}" var="prd">
	<tr>
		<td><c:out value="${prd.name}"></c:out></td>
		<td><c:out value="${prd.type}"></c:out></td>
	</tr>
</c:forEach>
	

</table>
</body>
</html>