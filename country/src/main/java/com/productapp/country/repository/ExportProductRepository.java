package com.productapp.country.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.productapp.country.model.ExportProduct;

@RepositoryRestResource(exported = false)
public interface ExportProductRepository extends PagingAndSortingRepository<ExportProduct, Integer>{
    
}
