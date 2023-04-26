package com.productapp.country.controller.param;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddCountry {
    private String name;
    private String code;
    private String isoCode;
}
