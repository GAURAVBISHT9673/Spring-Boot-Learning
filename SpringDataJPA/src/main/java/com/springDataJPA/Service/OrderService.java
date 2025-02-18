package com.springDataJPA.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDataJPA.Model.Orders;
import com.springDataJPA.Repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Orders AddOrder(Orders order) {
		// TODO Auto-generated method stub
		
		return orderRepository.save(order);
	}

	public List<Orders> findAllOrders() {
		// TODO Auto-generated method stub
		
		return (List<Orders>) orderRepository.findAll();
	}
		
	public Orders findOrderById(Integer id) {
		return orderRepository.findById(id).orElse(null);
	}
	
	public List<Orders> getOrderByName(String name){
		return orderRepository.findByCategory(name);
	}
	
}
