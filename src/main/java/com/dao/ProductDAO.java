package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Product;

public class ProductDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/productdb", "root", "admin");
    }

    // Add Product
    public void addProduct(Product p) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Products VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, p.getProductId());
        ps.setString(2, p.getProductName());
        ps.setString(3, p.getCategory());
        ps.setDouble(4, p.getPrice());
        ps.setInt(5, p.getQuantity());
        ps.executeUpdate();
        con.close();
    }

    // Update Product
    public void updateProduct(Product p) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE Products SET ProductName=?, Category=?, Price=?, Quantity=? WHERE ProductID=?");
        ps.setString(1, p.getProductName());
        ps.setString(2, p.getCategory());
        ps.setDouble(3, p.getPrice());
        ps.setInt(4, p.getQuantity());
        ps.setInt(5, p.getProductId());
        ps.executeUpdate();
        con.close();
    }

    // Delete Product
    public void deleteProduct(int id) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Products WHERE ProductID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // Display Products
    public List<Product> getAllProducts() throws Exception {
        List<Product> list = new ArrayList<>();
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Products");

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt(1));
            p.setProductName(rs.getString(2));
            p.setCategory(rs.getString(3));
            p.setPrice(rs.getDouble(4));
            p.setQuantity(rs.getInt(5));
            list.add(p);
        }
        con.close();
        return list;
    }
    
 // Price greater than value
    public List<Product> getProductsByPrice(double price) throws Exception {
        List<Product> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products WHERE Price > ?");
        ps.setDouble(1, price);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt(1));
            p.setProductName(rs.getString(2));
            p.setCategory(rs.getString(3));
            p.setPrice(rs.getDouble(4));
            p.setQuantity(rs.getInt(5));
            list.add(p);
        }
        con.close();
        return list;
    }

    // Category report
    public List<Product> getProductsByCategory(String category) throws Exception {
        List<Product> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products WHERE Category=?");
        ps.setString(1, category);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt(1));
            p.setProductName(rs.getString(2));
            p.setCategory(rs.getString(3));
            p.setPrice(rs.getDouble(4));
            p.setQuantity(rs.getInt(5));
            list.add(p);
        }
        con.close();
        return list;
    }

    // Top N products by quantity
    public List<Product> getTopProducts(int n) throws Exception {
        List<Product> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products ORDER BY Quantity DESC LIMIT ?");
        ps.setInt(1, n);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt(1));
            p.setProductName(rs.getString(2));
            p.setCategory(rs.getString(3));
            p.setPrice(rs.getDouble(4));
            p.setQuantity(rs.getInt(5));
            list.add(p);
        }
        con.close();
        return list;
    }
    
    

 // Check if Product ID already exists
 public boolean isProductExists(int id) throws Exception {
     boolean exists = false;

     Connection con = getConnection();
     PreparedStatement ps = con.prepareStatement(
         "SELECT ProductID FROM Products WHERE ProductID = ?");
     ps.setInt(1, id);

     ResultSet rs = ps.executeQuery();

     if (rs.next()) {
         exists = true;
     }

     con.close();
     return exists;
 }
}