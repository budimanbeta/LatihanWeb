package com.aprisma.latihan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product.do")
public class ProductListServlet extends HttpServlet {
	private static final String TO_ACTION_PRODUCT_LIST = "/product.do?action=list";
	private static final String VIEW_PRODUCTVIEW = "/WEB-INF/views/productview.jsp";
	private static final String VIEW_PRODUCTLIST = "/WEB-INF/views/productlist.jsp";
	private static final String ACTION_SAVE = "save";
	private static final String ACTION_VIEW = "view";
	private static final String ACTION_LIST = "list";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ProductRepository repo = new ProductRepositoryMysql();
		
		String action = request.getParameter("action");
		String targetDispaching = TO_ACTION_PRODUCT_LIST;
		
		if(ACTION_LIST.equals(action)) {
			List<Product> productList = repo.findAll();
			
			request.setAttribute("listOfProduct", productList);
			targetDispaching = VIEW_PRODUCTLIST;
			
		}else if(ACTION_VIEW.equals(action)) {
			int code = Integer.parseInt(request.getParameter("code"));
			Product product = repo.findById(code);
			
			request.setAttribute("product", product);
			targetDispaching = VIEW_PRODUCTVIEW;
		
		}else if (ACTION_SAVE.equals(action)) {
			int code = Integer.parseInt(request.getParameter("code"));
			String name = request.getParameter("id");
			String type = request.getParameter("type");
			int price = Integer.parseInt(request.getParameter("price"));
			
			int result = repo.save(new Product(code, name, type, price));
			request.setAttribute("message", "new product saved successfully !");
			
			
		}
		
		request.getRequestDispatcher(targetDispaching).forward(request, response);
		
		
	}
	
	private void dispatchTo(HttpServletRequest request,HttpServletResponse response, String target) throws ServletException, IOException {
		request.getRequestDispatcher(target).forward(request, response);
	}

}
