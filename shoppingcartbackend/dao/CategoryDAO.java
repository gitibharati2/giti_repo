package com.niit.shoppingcartbackend.dao;
import java.util.List;

import com.niit.shoppingcartbackend.model.Category;
public interface CategoryDAO
{
	 Category get(String id);
	 List<Category> list();
	 Boolean save(Category category);
	 Boolean update(Category category);
	 Boolean delete(Category category);
	 
	  
	 

}
