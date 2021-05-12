package com.teliacompany.task.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teliacompany.task.backend.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query(value="select price.commitment_months from price where price.id IN (select product_price.price_id from product_price  where product_price.product_id=:id)",nativeQuery = true)
	List<Integer> getcommitmentMonths(@Param("id")int id);

	@Query(value="select price.value from price where commitment_months = :commitment   and price.id IN\r\n"
			+ "(select product_price.price_id from product_price  where product_price.product_id= :productId)",nativeQuery = true)
	Integer getPriceCommitment(@Param("productId") int productId, @Param("commitment") int commitment);

	@Query(value="select price.value from price where commitment_months IS NULL   and price.id IN\r\n"
			+ "(select product_price.price_id from product_price  where product_price.product_id= :productId)",nativeQuery = true)
	Integer getInitalCharge(int productId);

}
