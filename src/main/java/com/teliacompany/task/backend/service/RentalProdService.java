package com.teliacompany.task.backend.service;

import java.util.List;

import com.teliacompany.task.backend.model.RentableProdCommitment;

public interface RentalProdService {

	List<String> getListOfRentableProduct();

	List<RentableProdCommitment> getProductCommitmentByName(String productName);

}
