package com.teliacompany.task.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teliacompany.task.backend.entity.Product;

/**
 * 
 * JPA repository to map with product table
 *
 */
@Repository
public interface RentableProductRepository extends JpaRepository<Product, Long> {

	@Query("select p.title from Product p where p.rentable=true")
	List<String> findByRentableProd();

	/*
	 * @Query(value =
	 * "select product.id,product.title,price.commitment_months from product join product_price ON product.id = product_price.product_id JOIN price ON price.id = product_price.price_id where product.title = 'Xbox Series X'"
	 * , nativeQuery = true) Collection<ProductDetail>
	 * getProductByName(@Param("productName") String productName);
	 */

	/*
	 * @Query("select p from Product p where p.rentable=true and p.title=:productName"
	 * ) List<Product> findByProductName(String productName);
	 */

	@Query("select p from Product p where p.rentable=true and p.title LIKE %:productName%")
	List<Product> findByProductName(String productName);

	@Query("select p.id from Product p where p.rentable=true and p.title=:productName")
	Optional<Integer> findProductIdByName(@Param("productName") String productName);

}
