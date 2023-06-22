package com.ascencio.dev.springwebfluxapi.service;

import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface FuncionaryService {

    Mono<FuncionaryResponseDto> findById(Integer id);

    Flux<FuncionaryResponseDto> findAll();

    Mono<FuncionaryResponseDto> create(FuncionaryDto request);

    Mono<FuncionaryResponseDto> update(Integer id, FuncionaryDto request);

    Mono<Void> delete(Integer id);
}
