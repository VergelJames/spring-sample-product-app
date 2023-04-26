package com.productapp.country.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// import com.apachekafka.apachekafka.service.ProducerService;
import com.productapp.country.controller.param.AddCountry;
import com.productapp.country.dto.CountryDTO;
import com.productapp.country.mapper.CountryMapper;
import com.productapp.country.model.Country;
import com.productapp.country.repository.CountryRepository;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);


    
    private KafkaTemplate<String, String> kafkaTemplate;

    public CountryService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }



    // @Autowired
    // ProducerService producerService;
    
    @Autowired
    CountryRepository countryRepository;

    public Page<Country> findCountries(Pageable pageable) {
        return this.countryRepository.findAll(pageable);
    }

    public List<Country> findCountries() {
        return this.countryRepository.findAllCountriesP();
    }

    public Country findCountryById(Integer id) {
        return this.countryRepository.findById(id).orElse(null);
    }

    public Country findCountryByName(String name) {
        return this.countryRepository.findByName(name);
    }

    public CountryDTO addCountry(AddCountry request){
        Country entity = CountryMapper.INSTANCE.requestToEntity(request);

        entity.setStatus("ACT");

        Country savedEntity = countryRepository.save(entity);

        //  CountryKDTO kafkadto = new CountryKDTO();

        //  kafkadto.setCode(savedEntity.getCode());
        //  kafkadto.setName(savedEntity.getName());
        //  kafkadto.setIsoCode(savedEntity.getIsoCode());

        // LOGGER.info(">>>>>>>>>>>>>>>>M<<<<<<<<" + kafkadto);

        CountryDTO savedDto = CountryMapper.INSTANCE.entityToDto(savedEntity);



        kafkaTemplate.send("amigos", "Hello world");


        return savedDto;
    }
}
