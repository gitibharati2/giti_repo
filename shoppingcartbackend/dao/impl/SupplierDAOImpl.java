package com.niit.shoppingcartbackend.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public Boolean save(Supplier supplier) {
	System.out.println("will save data");
		try{
			if(get(supplier.getId())!=null)
					{
				return false;
					}
			
			sessionFactory.getCurrentSession().save(supplier);
			System.out.println("data save");
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
}
		
		
	
@Transactional
	public Boolean update(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		
		
	}
@Transactional
	public Boolean delete(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
			
		}
		
		
	}

	public Supplier get(String id) {
		System.out.println("check id");
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
	}

	public List<Supplier> list() {
		String hql="from Supplier";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	
	}

}
