<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.aprisma.latihan.repositories.impl.ProductRepositoryMysql"%>
<%@page import="com.aprisma.latihan.repositories.ProductRepository"%>
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
<%
 long start = System.currentTimeMillis();
 ProductRepository productRepo = new ProductRepositoryMysql();
 List<Product> productList = productRepo.findAll();
 for(Product product : productList){
%>
	<tr>
		<td><%=product.getName() %></td>
		<td><%=product.getType() %></td>
	</tr>

<%} 

 long end = System.currentTimeMillis();
 NumberFormat formatter = new DecimalFormat("#0.00000");
 out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
%>

</table>
</body>
</html>