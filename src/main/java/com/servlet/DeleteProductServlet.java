package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.dao.ProductDAO;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            ProductDAO dao = new ProductDAO();
            dao.deleteProduct(id);

            res.sendRedirect("productdisplay");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}