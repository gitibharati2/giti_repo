package com.niit.shoppingcartbackend.dao;
import java.util.List;

import com.niit.shoppingcartbackend.model.Product;
public interface ProductDAO
{
	 Product get(String id);
	 List<Product> list();
	 Boolean save(Product product);
	 Boolean update(Product product);
	 Boolean delete(Product product);
	 
	  
	 

}
