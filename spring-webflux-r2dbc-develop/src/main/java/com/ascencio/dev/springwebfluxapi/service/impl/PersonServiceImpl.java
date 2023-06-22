package com.ascencio.dev.springwebfluxapi.service.impl;

import com.ascencio.dev.springwebfluxapi.domain.dto.PersonRequestDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.PersonResponseDto;
import com.ascencio.dev.springwebfluxapi.domain.mapper.PersonMapper;
import com.ascencio.dev.springwebfluxapi.domain.model.Person;
import com.ascencio.dev.springwebfluxapi.exception.ResourceNotFoundException;
import com.ascencio.dev.springwebfluxapi.repository.PersonRepository;
import com.ascencio.dev.springwebfluxapi.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ascencio.dev.springwebfluxapi.domain.mapper.PersonMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Mono<PersonResponseDto> findById(Integer id) {
        return this.personRepository.findById(id)
                .map(PersonMapper::toDto);
    }

    @Override
    public Flux<PersonResponseDto> findAll() {
        return this.personRepository.findAll()
                .map(PersonMapper::toDto);
    }

    @Override
    public Mono<PersonResponseDto> create(PersonRequestDto request) {
        return this.personRepository.save(toModel(request))
                .map(PersonMapper::toDto);
    }

    @Override
    public Mono<PersonResponseDto> update(Integer id, PersonRequestDto request) {
        return this.personRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .flatMap(person -> this.personRepository.save(toModel(person.getId(), request)))
                .map(PersonMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.personRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .then(this.personRepository.deleteById(id))
                .doOnSuccess(unused -> log.info("Se elimino el usuario con id: {}", id));
    }
}
