package com.ascencio.dev.springwebfluxapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PersonResponseDto implements Serializable {
   private static final long serialVersionUID = 8735757125749188522L;

   private Integer id;
   private String name;
   private String surname;
   private Integer age;
}
