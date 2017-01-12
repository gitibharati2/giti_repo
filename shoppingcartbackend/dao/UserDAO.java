package com.niit.shoppingcartbackend.dao;
import java.util.List;

import com.niit.shoppingcartbackend.model.User;


public interface UserDAO
{
	 User get(String id);
	 List<User> list();
	 Boolean save(User user);
	 Boolean update(User user);
	 Boolean delete(User user);
	 
	  
	 

}