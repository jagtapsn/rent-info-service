package com.teliacompany.task.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * Entity of prodcut price
 *
 */
@Entity
public class Product_Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	int product_id;
	
	int price_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getPrice_id() {
		return price_id;
	}

	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}
	
	

}
