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
<a href="index.jsp"> Home</a>
<hr>
<h2>Update Product</h2>



<form action="updateProduct" method="post">
   
    
    
    ID: <input type="text" name="id" value="<%=request.getParameter("id")!=null ? request.getParameter("id") : ""%>" readonly><br>

Name: <input type="text" name="name" value="<%=request.getParameter("name")!=null ? request.getParameter("name") : ""%>"><br>

Category: <input type="text" name="category" value="<%=request.getParameter("category")!=null ? request.getParameter("category") : ""%>"><br>

Price: <input type="text" name="price" value="<%=request.getParameter("price")!=null ? request.getParameter("price") : ""%>"><br>

Quantity: <input type="text" name="quantity" value="<%=request.getParameter("quantity")!=null ? request.getParameter("quantity") : ""%>"><br>
 <input type="submit" value="Update Product">
</form>
</body>
</html>