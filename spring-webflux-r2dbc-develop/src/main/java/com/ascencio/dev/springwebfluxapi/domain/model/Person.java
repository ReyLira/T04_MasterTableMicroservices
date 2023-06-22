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
public class Person {

    @Id
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    @Column("created_date")
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now(ZoneId.of("America/Lima"));

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(Integer id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
