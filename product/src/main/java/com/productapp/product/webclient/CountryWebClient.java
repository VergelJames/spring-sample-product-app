package com.productapp.product.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CountryWebClient {
    @Autowired
    @Qualifier("country")
    private WebClient countryApiWebClient;

}
