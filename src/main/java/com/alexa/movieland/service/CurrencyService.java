package com.alexa.movieland.service;

import com.alexa.movieland.entity.Movie;

public interface CurrencyService {
    void recalculatePrice(String currencyName, Movie movie);
}
