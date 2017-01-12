package com.niit.shoppingcartbackend.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;



@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public Boolean save(User user) {
	System.out.println("will save data");
		try{
			if(get(user.getId())!=null)
					{
				return false;
					}
			
			sessionFactory.getCurrentSession().save(user);
			System.out.println("data save");
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
}
		
		
	
@Transactional
	public Boolean update(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		
		
	}
@Transactional
	public Boolean delete(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		
		
	}

	public User get(String id) {
		System.out.println("check id");
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
	}

	public List<User> list() {
		String hql="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	
	}

}
