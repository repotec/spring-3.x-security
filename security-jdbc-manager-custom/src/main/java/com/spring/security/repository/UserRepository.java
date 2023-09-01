package com.spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "users-graph")
	Optional<User> findByUsername(String email);
}
