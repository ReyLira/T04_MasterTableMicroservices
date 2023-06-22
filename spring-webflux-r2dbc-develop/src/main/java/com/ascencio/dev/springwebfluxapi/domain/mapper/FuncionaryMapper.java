package com.ascencio.dev.springwebfluxapi.domain.mapper;

import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.FuncionaryResponseDto;
import com.ascencio.dev.springwebfluxapi.domain.model.Funcionary;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionaryMapper {

    public static Funcionary toModel(FuncionaryDto dto) {
        return new Funcionary(
                dto.getName(),
                dto.getSurname(),
                dto.getDni(),
                dto.getPhonenumber(),
                dto.getRank(),
                dto.getDepartment(),
                dto.getAddress(),
                dto.getEmail()
        );
    }

    public static Funcionary toModel(Integer id, FuncionaryDto dto) {
        return new Funcionary(
                id,
                dto.getName(),
                dto.getSurname(),
                dto.getDni(),
                dto.getPhonenumber(),
                dto.getRank(),
                dto.getDepartment(),
                dto.getAddress(),
                dto.getEmail()
        );
    }

    public static FuncionaryResponseDto toDto(Funcionary model) {
        return new FuncionaryResponseDto(
                model.getId(),
                model.getName(),
                model.getSurname(),
                model.getDni(),
                model.getPhonenumber(),
                model.getRank(),
                model.getDepartment(),
                model.getAddress(),
                model.getEmail()
        );
    }
}
