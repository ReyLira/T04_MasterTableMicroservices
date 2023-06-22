package com.ascencio.dev.springwebfluxapi.service;

import com.ascencio.dev.springwebfluxapi.domain.dto.PersonRequestDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.PersonResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface PersonService {

    Mono<PersonResponseDto> findById(Integer id);

    Flux<PersonResponseDto> findAll();

    Mono<PersonResponseDto> create(PersonRequestDto request);

    Mono<PersonResponseDto> update(Integer id, PersonRequestDto request);

    Mono<Void> delete(Integer id);
}
