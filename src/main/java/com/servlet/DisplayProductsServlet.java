package com.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.dao.ProductDAO;
import com.model.Product;

@WebServlet("/productdisplay")
public class DisplayProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.getAllProducts();

            req.setAttribute("products", list);
            RequestDispatcher rd = req.getRequestDispatcher("productdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}