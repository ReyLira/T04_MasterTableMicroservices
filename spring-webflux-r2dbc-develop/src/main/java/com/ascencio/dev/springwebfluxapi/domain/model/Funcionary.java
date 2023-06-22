package com.ascencio.dev.springwebfluxapi.domain.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Funcionary {

    @Id
    private Integer id;
    private String name;
    private String surname;
    private  String dni;
    private String phonenumber;
    private String rank;
    private String department;
    private String address;
    private String email;
    @Column("created_date")
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now(ZoneId.of("America/Lima"));

    public Funcionary(String name, String surname, String dni ,String phonenumber, String rank, String department,String address, String email) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.phonenumber = phonenumber;
        this.rank = rank;
        this.department = department;
        this.address = address;
        this.email = email;
    }

    public Funcionary(Integer id, String name, String surname,String dni ,String phonenumber, String rank, String department,String address,String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.phonenumber = phonenumber;
        this.rank = rank;
        this.department = department;
        this.address = address;
        this.email = email;
    }
}
