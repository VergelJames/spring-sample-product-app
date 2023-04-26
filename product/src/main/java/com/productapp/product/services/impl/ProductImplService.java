package com.productapp.product.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.product.config.KafkaPropsConfig;
import com.productapp.product.controller.params.AddProduct;
import com.productapp.product.dto.ExportProductDTO;
import com.productapp.product.dto.ProductDTO;
import com.productapp.product.exceptions.ProductExportException;
import com.productapp.product.mappers.ProductMapper;
import com.productapp.product.model.Product;
import com.productapp.product.repository.ProductRepository;
import com.productapp.product.services.ProductService;

import org.springframework.stereotype.Service;

@Service
public class ProductImplService implements ProductService {

    private final ProductRepository productRepository;

    public ProductImplService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductDTO addProduct(final AddProduct request){

        Product savedProduct = productRepository.save(ProductMapper.INSTANCE.requestToEntity(request));

        return ProductMapper.INSTANCE.entityToDto(savedProduct);
    }


    
}
