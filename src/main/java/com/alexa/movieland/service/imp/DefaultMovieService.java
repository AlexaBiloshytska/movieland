package com.alexa.movieland.service.imp;

import com.alexa.movieland.client.NBUClient;
import com.alexa.movieland.dao.MovieDao;
import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.service.CurrencyService;
import com.alexa.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
@Service
public class DefaultMovieService implements MovieService {
    private MovieDao movieDao;
    private int randomCount = 3;
    private NBUClient nbuClient;

    public DefaultMovieService(MovieDao movieDao, NBUClient nbuClient) {
        this.movieDao = movieDao;
        this.nbuClient = nbuClient;
    }
    @Autowired
    CurrencyService currencyService;

    @Override
    public List<Movie> getAll(LinkedHashMap<String, String> sortParams) {
        return movieDao.getAll(sortParams);
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandom(randomCount);
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId,LinkedHashMap<String, String> sortParams) {
        return movieDao.getMoviesByGenre(genreId, sortParams);
    }

    @Override
    public Movie getMovieById(int id, String currency) {
        Movie movieById = movieDao.getMovieById(id);
        if (currency == null || currency.equals("UAH")){
            return movieById;

        }
        if (currency.equals("USD")||(currency.equals("EUR"))) {
            currencyService.recalculatePrice(currency, movieById);
            return movieById;
        }
        throw new RuntimeException("Invalid currency entered");
    }

}

