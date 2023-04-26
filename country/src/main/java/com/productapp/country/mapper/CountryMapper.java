package com.productapp.country.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.productapp.country.controller.param.AddCountry;
import com.productapp.country.dto.CountryDTO;
import com.productapp.country.model.Country;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country dtoToEntity(CountryDTO dto);

    CountryDTO entityToDto(Country entity);

    List<Country> dtoListToEntityList(List<CountryDTO> dtoList);

    List<CountryDTO> entityListToDtoList(List<Country> entityList);

    Country requestToEntity(AddCountry request);
    
    // CountryKDTO entityToCoreCountryDTO(Country entity);
}
