package com.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.dao.ProductDAO;
import com.model.Product;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String type = req.getParameter("type");
            ProductDAO dao = new ProductDAO();
            List<Product> list = null;

            if (type.equals("price")) {
                double price = Double.parseDouble(req.getParameter("price"));
                list = dao.getProductsByPrice(price);

            } else if (type.equals("category")) {
                String category = req.getParameter("category");
                list = dao.getProductsByCategory(category);

            } else if (type.equals("top")) {
                int n = Integer.parseInt(req.getParameter("n"));
                list = dao.getTopProducts(n);
            }

            req.setAttribute("products", list);
            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}