package com.spring.security.repository;

import com.spring.security.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "users-graph")
	Optional<User> findByUsername(String username);
}
