package com.alexa.movieland.service.imp;

import com.alexa.movieland.client.NBUClient;
import com.alexa.movieland.entity.Currency;
import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCurrencyService implements CurrencyService {
    private final NBUClient nbuClient;
    private List<Currency> currencyCache;


    @Override
    public void recalculatePrice(String currencyName, Movie movie) {
        double priceUAH = movie.getPrice();

        Currency currency = getCurrency(currencyName);
        movie.setPrice(priceUAH/currency.getRate());
    }

    private Currency getCurrency(String currencyName) {
        for (Currency currency : currencyCache) {
            if (currency.getCc().equalsIgnoreCase(currencyName)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Unable to find currency: " + currencyName);
    }

    @PostConstruct
    public void updateCurrencies() {
        currencyCache = nbuClient.getCurrencies();
    }
}
