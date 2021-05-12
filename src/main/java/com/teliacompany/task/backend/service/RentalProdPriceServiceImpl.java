package com.teliacompany.task.backend.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teliacompany.task.backend.constant.RentProdConstant;
import com.teliacompany.task.backend.repository.PriceRepository;
import com.teliacompany.task.backend.repository.RentableProductRepository;

@Service
public class RentalProdPriceServiceImpl implements RentalProdPriceService {

	@Autowired
	RentableProductRepository productRepository;
	@Autowired
	PriceRepository priceRepository;

	private static final Logger log = LogManager.getLogger(RentalProdPriceServiceImpl.class);

	/**
	 * calculate the total price of of gaming equipment for the chosen rental period
	 */
	public String getRentableProductPrice(String productName, String commitment, Integer returnsMonth) {
		if (commitment.equalsIgnoreCase(RentProdConstant.NOCOMMITMENT)) {
			return getPrice(productName, returnsMonth);
		} else if (returnsMonth == null || (Integer.valueOf(commitment) == returnsMonth))
			return getPrice(productName, Integer.valueOf(commitment));
		else
			return getPrice(productName, returnsMonth);

	}

	/**
	 * get price of equipment for chosen rental period
	 * 
	 * @param productName chosen product
	 * @param commitment  commitment time
	 * @return
	 */
	private String getPrice(String productName, int commitment) {
		log.info("Calculate price of gaming equipment on rent");
		Optional<Integer> productId = productRepository.findProductIdByName(productName);
		if (productId.isPresent()) {
			log.info("Get inital rent charge of gaming equipment");
			int initalCharge = priceRepository.getInitalCharge(productId.get());
			double price;
			if (commitment == 3 || commitment == 6) {
				log.info("Get rent price of commitment month for gaming equipment");
				int commitmentprice = priceRepository.getPriceCommitment(productId.get(), commitment);
				price = initalCharge + (commitment * commitmentprice);
			} else {
				log.info("Get rent price of non commitment month for gaming equipment");
				price = initalCharge + (commitment * initalCharge);
			}

			return productName + RentProdConstant.GERENT + String.valueOf(price);

		} else {
			return productName + RentProdConstant.GENA;
		}
	}

}
