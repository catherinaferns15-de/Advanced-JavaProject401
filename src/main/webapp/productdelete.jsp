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
<h2>Delete Product</h2>

<form action="deleteProduct" method="post">
    Enter Product ID: <input type="text" name="id"><br>
    <input type="submit" value="Delete Product">
</form>
</body>
</html>