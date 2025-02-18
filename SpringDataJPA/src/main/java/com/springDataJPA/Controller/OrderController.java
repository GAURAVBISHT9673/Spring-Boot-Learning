package com.springDataJPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.springDataJPA.Model.Orders;
import com.springDataJPA.Service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("listoforder")
	public ResponseEntity<List<Orders>> listofOrders() {
		return new ResponseEntity<List<Orders>>(orderService.findAllOrders(), HttpStatus.OK);
	}
	
	@PostMapping("addOrder")
	public ResponseEntity<Orders> AddOrder(@RequestBody Orders order) {
		
		return new ResponseEntity<>(orderService.AddOrder(order),HttpStatus.CREATED);
	}
	
	@GetMapping("Order/{id}")
	public ResponseEntity<Orders> findOrder(@PathVariable Integer id){
		
		Orders order = orderService.findOrderById(id);
		
		if (order != null) 
			return new ResponseEntity<>(order,HttpStatus.FOUND);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("OrderName/{name}")
	public ResponseEntity<List<Orders>> listFindByOrdersName(@PathVariable String name){
		
		List<Orders> list = orderService.getOrderByName(name);
		
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Orders>>(list,HttpStatus.FOUND);		
		}
		else {
			return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
}
