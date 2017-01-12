package com.niit.shoppingcartbackend.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public Boolean save(Product poduct) {
	System.out.println("will save data");
		try{
			if(get(product.getId())!=null)
					{
				return false;
					}
			
			sessionFactory.getCurrentSession().save(product);
			System.out.println("data save");
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
}
		
		
	
@Transactional
	public Boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		
		
	}
@Transactional
	public Boolean delete(Product product) {
		try{
			sessionFactory.getCurrentSession().delete(product);
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		
		
	}

	public Product get(String id) {
		System.out.println("check id");
		return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
	}

	public List<Product> list() {
		String hql="from Product";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	
	}

}
