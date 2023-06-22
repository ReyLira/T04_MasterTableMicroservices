package com.ascencio.dev.springwebfluxapi.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonRequestDto implements Serializable {
    private static final long serialVersionUID = 8222253670338491507L;

    private String name;
    private String surname;
    private Integer age;

}
