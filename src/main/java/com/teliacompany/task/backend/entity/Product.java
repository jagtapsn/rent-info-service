package com.teliacompany.task.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * Entity of product
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String title;

	boolean rentable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRentable() {
		return rentable;
	}

	public void setRentable(boolean rentable) {
		this.rentable = rentable;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", rentable=" + rentable + "]";
	}
   
}
