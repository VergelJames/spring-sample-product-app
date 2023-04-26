package com.productapp.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.product.controller.params.AddProduct;
import com.productapp.product.controller.params.ExportProduct;
import com.productapp.product.services.ProductExportService;
import com.productapp.product.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductExportService productExportService;

    @PostMapping("products")
    public ResponseEntity<Object> add(@RequestBody AddProduct request){
        return new ResponseEntity<>(this.productService.addProduct(request), HttpStatus.OK);
    }

    @PostMapping("products/export")
    public ResponseEntity<Object> exportProduct(@RequestBody ExportProduct request){
        productExportService.export(request);
        return new ResponseEntity<>("Successfully exported product.", HttpStatus.OK);
    }

    
}
