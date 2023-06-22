package com.ascencio.dev.springwebfluxapi.web;

import com.ascencio.dev.springwebfluxapi.domain.dto.PersonRequestDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.PersonResponseDto;
import com.ascencio.dev.springwebfluxapi.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<PersonResponseDto> findAll() {
        return this.personService.findAll();
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<PersonResponseDto> findById(@PathVariable Integer id) {
        return this.personService.findById(id);
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<PersonResponseDto> update(@PathVariable Integer id, @RequestBody PersonRequestDto dto) {
        return this.personService.update(id, dto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<PersonResponseDto> create(@RequestBody PersonRequestDto dto) {
        return this.personService.create(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return this.personService.delete(id);
    }
}
