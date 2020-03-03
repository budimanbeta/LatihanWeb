package com.aprisma.latihan.repositories;
import java.util.*;

import com.aprisma.latihan.model.Product;



public interface ProductRepository {
	public List<Product> findAll();
	public Product findById(int id);
	public int save(Product product);
}
