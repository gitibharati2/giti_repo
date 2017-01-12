package com.niit.shoppingcartbackend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="PRODUCT")
@Component()
public class Product {
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private int price;
	private String category_id;
	@ManyToOne
    @JoinColumn(name="category_id", nullable = false, updatable = false, insertable = false)
   	private Category category;
	private String supplier_id;
	@ManyToOne
	   @JoinColumn(name="supplier_id",nullable = false, updatable = false, insertable = false)
		private Supplier supplier;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	

}