<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Product Management System</title>
  <link rel="stylesheet" href="style_product_list.css">
</head>
<body>

<%@ page import="java.util.*,com.model.Product" %>
<a href="index.jsp">Home</a>
<hr>
<h2>Product List</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Quantity</th><th>Action</th> 
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
<td>
    <!-- Update Button -->
    <form action="updateProduct" method="get" style="display:inline;">
        <input type="hidden" name="id" value="<%=p.getProductId()%>">
        <input type="hidden" name="name" value="<%=p.getProductName()%>">
        <input type="hidden" name="category" value="<%=p.getCategory()%>">
        <input type="hidden" name="price" value="<%=p.getPrice()%>">
        <input type="hidden" name="quantity" value="<%=p.getQuantity()%>">

        <input type="submit" value="Update">
    </form>

    <!-- Delete Button -->
    <form action="deleteProduct" method="post" style="display:inline;">
        <input type="hidden" name="id" value="<%=p.getProductId()%>">
        <input type="submit" value="Delete"
               onclick="return confirm('Delete this product?');">
    </form>
</td>
</tr>
<% } %>

</table>

</body>
</html>