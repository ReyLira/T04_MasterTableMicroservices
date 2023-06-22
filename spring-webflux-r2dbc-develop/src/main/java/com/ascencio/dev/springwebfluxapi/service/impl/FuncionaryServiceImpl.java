package com.ascencio.dev.springwebfluxapi.service.impl;

import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryResponseDto;
import com.ascencio.dev.springwebfluxapi.domain.mapper.FuncionaryMapper;
import com.ascencio.dev.springwebfluxapi.domain.model.Person;
import com.ascencio.dev.springwebfluxapi.exception.ResourceNotFoundException;
import com.ascencio.dev.springwebfluxapi.repository.FuncionaryRepository;
import com.ascencio.dev.springwebfluxapi.service.FuncionaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ascencio.dev.springwebfluxapi.domain.mapper.FuncionaryMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class FuncionaryServiceImpl implements FuncionaryService {

    private final FuncionaryRepository funcionaryRepository;

    @Override
    public Mono<FuncionaryResponseDto> findById(Integer id) {
        return this.funcionaryRepository.findById(id)
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Flux<FuncionaryResponseDto> findAll() {
        return this.funcionaryRepository.findAll()
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<FuncionaryResponseDto> create(FuncionaryDto request) {
        return this.funcionaryRepository.save(toModel(request))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<FuncionaryResponseDto> update(Integer id, FuncionaryDto request) {
        return this.funcionaryRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .flatMap(person -> this.funcionaryRepository.save(toModel(person.getId(), request)))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.funcionaryRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .then(this.funcionaryRepository.deleteById(id))
                .doOnSuccess(unused -> log.info("Se elimino el usuario con id: {}", id));
    }
}
