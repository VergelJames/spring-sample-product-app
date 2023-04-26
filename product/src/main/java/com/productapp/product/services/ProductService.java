package com.productapp.product.services;

import com.productapp.product.controller.params.AddProduct;
import com.productapp.product.dto.ExportProductDTO;
import com.productapp.product.dto.ProductDTO;

public interface ProductService {

    ProductDTO addProduct(AddProduct request);

}
