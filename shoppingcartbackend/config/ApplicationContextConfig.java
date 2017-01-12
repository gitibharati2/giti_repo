package com.niit.shoppingcartbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.impl.CategoryDAOImpl;
import com.niit.shoppingcartbackend.dao.impl.SupplierDAOImpl;
import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.model.Supplier;


@Configuration
@ComponentScan("com.niit.shoppingcartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	   
System.out.println("database");
	    return  dataSource;
	}
	
  private Properties getHibernateProperties()
  {
	  Properties properties =new Properties();
	 properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	
	  System.out.println("prop");
	  return properties;
  }
  @Autowired
  @Bean(name="sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource)
  {
	 LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource); 
	 
	 sessionBuilder.addProperties(getHibernateProperties());
	 
	 sessionBuilder.addAnnotatedClass(Category.class);
	 sessionBuilder.addAnnotatedClass(Supplier.class);
	 sessionBuilder.addAnnotatedClass(Product.class);
	 System.out.println("session");
	 return sessionBuilder.buildSessionFactory();
  }
  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

      HibernateTransactionManager transactionManager = new   HibernateTransactionManager(sessionFactory);
     
      return transactionManager;
  }
  
  @Autowired
  @Bean(name = "categoryDAO")
  public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("dao");
  	return new CategoryDAOImpl(sessionFactory);
  }
  @Autowired
  @Bean(name = "supplierDAO")
  public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("dao");
  	return new SupplierDAOImpl(sessionFactory);
  }
  @Autowired
  @Bean(name = "productDAO")
  public ProductDAO getProductDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("dao");
  	return new ProductDAOImpl(sessionFactory);
  }
}
