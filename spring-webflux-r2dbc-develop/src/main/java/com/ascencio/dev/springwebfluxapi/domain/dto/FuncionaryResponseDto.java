package com.ascencio.dev.springwebfluxapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FuncionaryResponseDto implements Serializable {
    private static final long serialVersionUID = 8635752125749188522L;

    private Integer id;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phonenumber;
    private String rank;
    private String department;
    private String address;
}
