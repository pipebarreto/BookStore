package com.example.Diego_bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}