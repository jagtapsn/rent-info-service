package com.teliacompany.task.backend.model;

import java.util.List;

/**
 * 
 * Model class cantain commitmentMonths of rentable product
 *
 */
public class RentableProdCommitment {

	String title;
	List<Integer> commitmentMonths;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getCommitmentMonths() {
		return commitmentMonths;
	}

	public void setCommitmentMonths(List<Integer> commitmentMonths) {
		this.commitmentMonths = commitmentMonths;
	}

}
