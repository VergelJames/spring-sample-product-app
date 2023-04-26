package com.productapp.country.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.productapp.country.model.Country;

@RepositoryRestResource(exported = false)
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
    
    Country findByName(@Param("name") String name);

    @Query("SELECT c FROM Country c WHERE c.status = 'ACT' ORDER BY c.name ASC")
    List<Country> findAllCountriesP();
}
