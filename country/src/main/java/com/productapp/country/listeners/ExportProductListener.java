package com.productapp.country.listeners;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.apache.bcel.classfile.Module.Export;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.country.exceptions.InvalidMessageException;
import com.productapp.country.model.ExportProduct;
import com.productapp.country.repository.ExportProductRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExportProductListener {

    private final ObjectMapper objectMapper;

    private final ExportProductRepository exportProductRepository;

    public ExportProductListener(
        final ObjectMapper objectMapper, final ExportProductRepository exportProductRepository){
            this.objectMapper = objectMapper;
            this.exportProductRepository = exportProductRepository;
        }
    
    
    @KafkaListener(topics = "export.product")
	public String listens(final String in) {
		log.info("Product to be Export: {}", in);
		try {
			final Map<String, Object> payload = readJsonAsMap(in);

			final ExportProduct book = mapExportProductPayload(payload);
			exportProductRepository.save(book);

		} catch(final InvalidMessageException ex) {
			log.error("Invalid message received: {}", in);
		}
		return in;
	}

	private Map<String, Object> readJsonAsMap(final String json) {
		try{
			final TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
			return objectMapper.readValue(json, typeRef);
		} catch(JsonProcessingException ex) {
			throw new InvalidMessageException();
		}
	}


    private ExportProduct mapExportProductPayload(final Map<String, Object> payload){

		log.info("Hello world!!" + payload);
        return ExportProduct.builder()
        .country(payload.get("countryName").toString())
        .product(payload.get("productName").toString())
        .build();
        
        
    }

}
