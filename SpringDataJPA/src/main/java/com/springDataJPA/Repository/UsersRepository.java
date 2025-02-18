package com.springDataJPA.Repository;

import org.springframework.data.repository.CrudRepository;

import com.springDataJPA.Model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

}
