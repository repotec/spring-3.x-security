package com.spring.security.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.User;

@Repository
public interface CustomerRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String email);
}
