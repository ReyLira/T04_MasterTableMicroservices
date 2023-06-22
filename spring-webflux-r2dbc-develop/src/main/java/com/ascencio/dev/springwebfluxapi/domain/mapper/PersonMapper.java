package com.ascencio.dev.springwebfluxapi.domain.mapper;

import com.ascencio.dev.springwebfluxapi.domain.dto.PersonRequestDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.PersonResponseDto;
import com.ascencio.dev.springwebfluxapi.domain.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMapper {

    public static Person toModel(PersonRequestDto dto) {
        return new Person(
                dto.getName(),
                dto.getSurname(),
                dto.getAge()
        );
    }

    public static Person toModel(Integer id, PersonRequestDto dto) {
        return new Person(
                id,
                dto.getName(),
                dto.getSurname(),
                dto.getAge()
        );
    }

    public static PersonResponseDto toDto(Person model) {
        return new PersonResponseDto(
                model.getId(),
                model.getName(),
                model.getSurname(),
                model.getAge()
        );
    }
}
