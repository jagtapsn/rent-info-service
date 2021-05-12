package com.teliacompany.task.backend.api.v1;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teliacompany.task.backend.model.RentableProdCommitment;
import com.teliacompany.task.backend.service.RentalProdPriceService;
import com.teliacompany.task.backend.service.RentalProdService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class RentalProdController {

	private static final Logger log = LogManager.getLogger(RentalProdController.class);
	
	@Autowired
	RentalProdService rentalProdService;

	@Autowired
	RentalProdPriceService rentalProdPriceService;

	/**
	 * Provide information about list of gaming equipment for rent
	 * 
	 * @return rental product list
	 */
	@Operation(summary = "Get a list of gaming equipment for rent")
	@GetMapping("/getRentableProductList")
	public List<String> getListOfRentableProduct() {
		log.info("Get list of gaming equipment for rent");
		return rentalProdService.getListOfRentableProduct();
	}

	/**
	 * Provide information about title of gaming equipment for rent and possible
	 * commitment options.
	 * 
	 * @param productName
	 * @return
	 */
	@Operation(summary = "Get title of gaming equipment for rent and possible commitment options. We can search product with full name or some identification of product")
	@GetMapping("/getProductCommitmentByName")
	public List<RentableProdCommitment> getProductCommitmentByName(@RequestParam("productName") String productName) {
		log.info("Get title of gaming equipment for rent and possible commitment months option");
		return rentalProdService.getProductCommitmentByName(productName);
	}

	/**
	 * calculate the total price of of gaming equipment for the chosen rental period
	 * 
	 * @param productName  chosen product
	 * @param commitment   commitment time
	 * @param returnsMonth the number of months after which they will return the
	 *                     equipment
	 * @return  rent price
	 */
	@Operation(summary = "Calculate the total price of gaming equipment for the chosen rental period")
	@GetMapping("/getRentableProductPrice")
	public String getRentedProductPrice(@RequestParam("productName") String productName,
			@RequestParam("commitment") String commitment, @RequestParam(required = false) Integer returnsMonth) {
		log.info("Calculate the total price of gaming equipment for the chosen rental period");
		return rentalProdPriceService.getRentableProductPrice(productName, commitment, returnsMonth);

	}

}
