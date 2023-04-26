package com.productapp.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.country.controller.param.AddCountry;
import com.productapp.country.dto.CountryDTO;
import com.productapp.country.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("countries")
    public ResponseEntity<Object> findCountries(Pageable pageable) {
        return new ResponseEntity<>(this.countryService.findCountries(pageable), HttpStatus.OK);
    }

    @GetMapping("countries/List")
    public ResponseEntity<Object> findListCountries() {
        return new ResponseEntity<>(this.countryService.findCountries(), HttpStatus.OK);
    }
    
    @GetMapping("countries/{id}")
    public ResponseEntity<Object> findCountryById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(this.countryService.findCountryById(id), HttpStatus.OK);
    }

    @GetMapping("countries/search")
    public ResponseEntity<Object> findCountryByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(this.countryService.findCountryByName(name), HttpStatus.OK);
    }

    @PostMapping("countries")
    public ResponseEntity<Object> addCountry(@RequestBody AddCountry request){
        CountryDTO savedDto = this.countryService.addCountry(request);
        // kafkaTemplate.send("amigos", savedDto);
        return new ResponseEntity<Object>(savedDto, HttpStatus.CREATED);
    }

}
