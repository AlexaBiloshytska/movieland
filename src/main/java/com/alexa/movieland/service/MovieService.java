package com.alexa.movieland.service;

import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.entity.SortingEnum;

import java.util.LinkedHashMap;
import java.util.List;

public interface MovieService {
List<Movie> getAll(LinkedHashMap<String, String> sortParams);
    List<Movie> getRandom();
    List<Movie> getMoviesByGenre(int genreId,LinkedHashMap<String, String> sortParams);
    Movie getMovieById(int id,  String currency);
}
