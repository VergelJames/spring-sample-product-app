package com.productapp.product.services;


import com.productapp.product.controller.params.ExportProduct;

public interface ProductExportService {
    void export(ExportProduct exportProductDto);
}
