<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Product Management System</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<%@ page import="java.util.*,com.model.Product" %>
<a href="index.jsp"> Home</a>
<hr>
<h2>Report Result</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Quantity</th>
</tr>

<%
List<Product> list = (List<Product>)request.getAttribute("products");
for(Product p : list){
%>

<tr>
<td><%=p.getProductId()%></td>
<td><%=p.getProductName()%></td>
<td><%=p.getCategory()%></td>
<td><%=p.getPrice()%></td>
<td><%=p.getQuantity()%></td>
</tr>

<% } %>

</table>
</body>
</html>