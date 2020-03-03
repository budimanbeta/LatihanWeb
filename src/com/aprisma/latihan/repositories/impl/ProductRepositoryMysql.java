package com.aprisma.latihan.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aprisma.latihan.model.Product;
import com.aprisma.latihan.repositories.ProductRepository;


public class ProductRepositoryMysql implements ProductRepository{
	
	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		try {
		
			Connection conn = DBConnection.getConnection();
			
			String sql = "Select * from product";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Product product = new Product();
				product.setCode(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setType(rs.getString("type"));
				product.setPrice(rs.getInt("price"));
				
				products.add(product);
			}
			
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return products;
	}

	@Override
	public Product findById(int id) {
		Product product = null;
		try {
			Connection conn = DBConnection.getConnection();
			
			String sql = "Select * from product where id = '"+ id +"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				 product = new Product();
				product.setCode(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setType(rs.getString("type"));
				product.setPrice(rs.getInt("price"));
				
				
			}
			
			stm.close();
			conn.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public int save(Product product) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			
			String sql = "insert into product(id,name,type,price) values(?,?,?,?)";
			
			PreparedStatement pStm = conn.prepareStatement(sql);
			pStm.setInt(1, product.getCode());
			pStm.setString(2, product.getName());
			pStm.setString(3, product.getType());
			pStm.setInt(4, product.getPrice());
			
			result = pStm.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
