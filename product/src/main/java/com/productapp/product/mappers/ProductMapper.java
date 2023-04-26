package com.productapp.product.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.productapp.product.controller.params.AddProduct;
import com.productapp.product.dto.ProductDTO;
import com.productapp.product.model.Product;

@Mapper
public interface ProductMapper  {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product dtoToEntity(ProductDTO dto);

    ProductDTO entityToDto(Product entity);

    List<Product> dtoListToEntityList(List<ProductDTO> dtoList);

    List<ProductDTO> entityListToDtoList(List<Product> entityList);

    Product requestToEntity(AddProduct request);
}
