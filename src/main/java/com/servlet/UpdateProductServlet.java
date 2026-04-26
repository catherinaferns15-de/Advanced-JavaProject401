package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.dao.ProductDAO;
import com.model.Product;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    try {
	        String idStr = req.getParameter("id");
	        String name = req.getParameter("name");
	        String category = req.getParameter("category");
	        String priceStr = req.getParameter("price");
	        String quantityStr = req.getParameter("quantity");

	        // Null & Empty check
	        if (idStr == null || idStr.trim().isEmpty() ||
	            name == null || name.trim().isEmpty() ||
	            category == null || category.trim().isEmpty() ||
	            priceStr == null || priceStr.trim().isEmpty() ||
	            quantityStr == null || quantityStr.trim().isEmpty()) {

	            //out.println("<h3 style='color:red;'>All fields are required!</h3>");
	            

                req.setAttribute("error", "All fields are required!");
                RequestDispatcher rd = req.getRequestDispatcher("updateProduct.jsp");
                rd.forward(req, res);
                
	            return;
	        }

	        int id;
	        double price;
	        int quantity;

	        // Type check
	        try {
	            id = Integer.parseInt(idStr);
	            price = Double.parseDouble(priceStr);
	            quantity = Integer.parseInt(quantityStr);
	        } catch (NumberFormatException e) {
	            //out.println("<h3 style='color:red;'>Invalid number format!</h3>");
	        	 req.setAttribute("error", "Invalid number format!");
	                RequestDispatcher rd = req.getRequestDispatcher("updateProduct.jsp");
	                rd.forward(req, res);
	                
	            return;
	        }

	        // Logical check
	        if (id <= 0 || price <= 0 || quantity < 0) {
	            //out.println("<h3 style='color:red;'>Enter valid values!</h3>");
	        	
	       	 req.setAttribute("error", "Enter valid values!");
             RequestDispatcher rd = req.getRequestDispatcher("updateProduct.jsp");
             rd.forward(req, res);
	            return;
	        }

	        Product p = new Product();
	        p.setProductId(id);
	        p.setProductName(name.trim());
	        p.setCategory(category.trim());
	        p.setPrice(price);
	        p.setQuantity(quantity);

	        ProductDAO dao = new ProductDAO();
	        dao.updateProduct(p);

	        res.sendRedirect("productdisplay");

	    } catch (Exception e) {
	        out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
	    }
	}
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get values from request
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("category", req.getParameter("category"));
        req.setAttribute("price", req.getParameter("price"));
        req.setAttribute("quantity", req.getParameter("quantity"));

        // Forward to JSP
        RequestDispatcher rd = req.getRequestDispatcher("productupdate.jsp");
        rd.forward(req, res);
    }
}

