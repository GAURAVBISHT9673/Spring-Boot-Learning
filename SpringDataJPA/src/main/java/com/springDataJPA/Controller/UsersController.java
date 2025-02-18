package com.springDataJPA.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springDataJPA.Model.Users;
import com.springDataJPA.Service.UsersService;

@Controller
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/Users")
	public ResponseEntity<List<Users>> getListOfUsers(){
		return new ResponseEntity<List<Users>>(usersService.findallUsers(),HttpStatus.FOUND);
	}
	
	@PostMapping("/User")
	public ResponseEntity<Users> createNewUser(@RequestBody Users users){
		return new ResponseEntity<Users>(usersService.createNewUsers(users),HttpStatus.CREATED);
	}
	
	@GetMapping("/User/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable Integer id){
		return new ResponseEntity<Users>(usersService.findusersById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/User/{id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users users){
		return new ResponseEntity<Users>(usersService.updateUsers(users),HttpStatus.ACCEPTED);
	}
	
}
