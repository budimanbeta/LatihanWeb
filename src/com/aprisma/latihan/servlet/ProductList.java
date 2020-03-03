package com.aprisma.latihan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aprisma.latihan.model.Product;
import com.aprisma.latihan.repositories.ProductRepository;
import com.aprisma.latihan.repositories.impl.ProductRepositoryMysql;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/products.do")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProductList() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		long start = System.currentTimeMillis();
		ProductRepository productRepo = new ProductRepositoryMysql();
		 List<Product> productList = productRepo.findAll();
		 out.println("<table border=1>");
		 out.println("<tr>");
		 out.println("<th>Name </th>");
		 out.println("<th>Type </th>");
		 out.println("</tr>");
		 
		 for(Product product : productList){
			 out.println("<tr>");
			 out.println("<td>"+ product.getName() + "</td>");
			 out.println("<td>"+ product.getType() + "</td>");
			 out.println("</tr>");
		 }
		 
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	}

	

}
