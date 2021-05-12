package com.teliacompany.task.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * Entity class of price
 *
 */
@Entity
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	Integer commitmentMonths;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommitmentMonths() {
		return commitmentMonths;
	}

	public void setCommitmentMonths(Integer commitmentMonths) {
		this.commitmentMonths = commitmentMonths;
	}

}
