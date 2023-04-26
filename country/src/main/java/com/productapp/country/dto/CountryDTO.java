package com.productapp.country.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDTO {
    private Integer id;
    private String  name;
    private String  code;
    private String  isoCode;
}
