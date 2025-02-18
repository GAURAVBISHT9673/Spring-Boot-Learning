package com.springDataJPA.Repository;

import org.springframework.data.repository.CrudRepository;

import com.springDataJPA.Model.Orders;
import java.util.List;


public interface OrderRepository extends CrudRepository<Orders, Integer> {

	List<Orders> findByCategory(String category);
	
}
