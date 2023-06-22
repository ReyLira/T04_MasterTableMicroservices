package com.ascencio.dev.springwebfluxapi.web;

import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryResponseDto;
import com.ascencio.dev.springwebfluxapi.service.FuncionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/funcionary")
@RequiredArgsConstructor
public class FuncionaryController {
    private final FuncionaryService funcionaryService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<FuncionaryResponseDto> findAll() {
        return this.funcionaryService.findAll();
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<FuncionaryResponseDto> findById(@PathVariable Integer id) {
        return this.funcionaryService.findById(id);
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<FuncionaryResponseDto> update(@PathVariable Integer id, @RequestBody FuncionaryDto dto) {
        return this.funcionaryService.update(id, dto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<FuncionaryResponseDto> create(@RequestBody FuncionaryDto dto) {
        return this.funcionaryService.create(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return this.funcionaryService.delete(id);
    }
}
