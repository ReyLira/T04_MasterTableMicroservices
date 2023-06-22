package com.ascencio.dev.springwebfluxapi.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FuncionaryDto implements Serializable {
    private static final long serialVersionUID = 8232243670338491507L;

    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phonenumber;
    private String rank;
    private String department;
    private String address;


}
