package com.alexa.movieland.client;

import com.alexa.movieland.entity.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class NBUClient {
    @Value("${currencyUrl}")
    private String currencyUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Currency> getCurrencies() {
        ResponseEntity<List<Currency>> response = restTemplate.exchange(
                currencyUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Currency>>() {
                });
        return response.getBody();
    }
}
