package com.springDataJPA.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDataJPA.Model.Address;
import com.springDataJPA.Model.Users;
import com.springDataJPA.Repository.AddressRepository;
import com.springDataJPA.Repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Users> findallUsers(){
		return (List<Users>) usersRepository.findAll();
	}
	
	public Users createNewUsers(Users users) {		
		return usersRepository.save(users);
	}
	
	public Users findusersById(Integer id) {
		return usersRepository.findById(id).get();
	}
	
	public Users updateUsers(Users users) {
		return usersRepository.save(users);		
	}
	
}
