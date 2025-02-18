package com.springDataJPA.Repository;

import org.springframework.data.repository.CrudRepository;

import com.springDataJPA.Model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
