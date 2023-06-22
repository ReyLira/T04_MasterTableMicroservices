package com.ascencio.dev.springwebfluxapi.repository;

import com.ascencio.dev.springwebfluxapi.domain.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {
}

