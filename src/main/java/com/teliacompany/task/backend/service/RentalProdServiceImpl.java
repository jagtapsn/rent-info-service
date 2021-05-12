package com.teliacompany.task.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teliacompany.task.backend.entity.Product;
import com.teliacompany.task.backend.model.RentableProdCommitment;
import com.teliacompany.task.backend.repository.PriceRepository;
import com.teliacompany.task.backend.repository.RentableProductRepository;

@Service
public class RentalProdServiceImpl implements RentalProdService {

	@Autowired
	RentableProductRepository productRepository;
	@Autowired
	PriceRepository priceRepository;
	private static final Logger log = LogManager.getLogger(RentalProdServiceImpl.class);

	/**
	 * return list of product on rent
	 */
	@Override
	public List<String> getListOfRentableProduct() {
		log.info("Get a list of gaming equipment for rent");
		return productRepository.findByRentableProd();
	}

	/**
	 * Return information about title of gaming equipment for rent and possible
	 * commitment options.
	 */
	@Override
	public List<RentableProdCommitment> getProductCommitmentByName(String productName) {

		log.info("Get a list of gaming equipment title and commitment options");
		List<Product> listOfProducts = productRepository.findByProductName(productName);

		List<RentableProdCommitment> rProdCommitments = new ArrayList<>();

		listOfProducts.stream().forEach(product -> {
			RentableProdCommitment rentableProdCommitment = new RentableProdCommitment();

			rentableProdCommitment.setTitle(product.getTitle());
			log.info("Get a list commitment month options for gaming equipment");
			rentableProdCommitment.setCommitmentMonths(priceRepository.getcommitmentMonths(product.getId()));
			rProdCommitments.add(rentableProdCommitment);

		});
		return rProdCommitments;
	}

}
