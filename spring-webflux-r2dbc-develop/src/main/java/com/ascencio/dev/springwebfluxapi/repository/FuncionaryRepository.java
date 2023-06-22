package com.ascencio.dev.springwebfluxapi.repository;

import com.ascencio.dev.springwebfluxapi.domain.model.Funcionary;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionaryRepository extends ReactiveCrudRepository<Funcionary, Integer> {
}
