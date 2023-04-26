package com.productapp.product.services.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.product.config.KafkaPropsConfig;
import com.productapp.product.controller.params.AddProduct;
import com.productapp.product.controller.params.ExportProduct;
import com.productapp.product.dto.ExportProductDTO;
import com.productapp.product.dto.ProductDTO;
import com.productapp.product.exceptions.ProductExportException;
import com.productapp.product.services.ProductExportService;
import com.productapp.product.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductExportKafkaService implements ProductExportService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaPropsConfig kafkaPropsConfig;

    public ProductExportKafkaService(
            final ObjectMapper objectMapper,
            final KafkaTemplate<String, String> kafkaTemplate,
            final KafkaPropsConfig kafkaPropsConfig) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaPropsConfig = kafkaPropsConfig;
    }

    @Override
    public void export(final ExportProduct exportProduct) {
        try {
            final String payload = objectMapper.writeValueAsString(exportProduct);
            log.info(payload + "hello world" + kafkaPropsConfig.getTopic());
            kafkaTemplate.send(kafkaPropsConfig.getTopic(), payload);
        } catch (final JsonProcessingException ex) {
            throw new ProductExportException("Unable to export product", ex, exportProduct);
        }
    }



}
