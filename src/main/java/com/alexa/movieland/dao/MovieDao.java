package com.alexa.movieland.dao;

import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.entity.SortingEnum;

import java.util.LinkedHashMap;
import java.util.List;

public interface MovieDao {
    List<Movie> getAll(LinkedHashMap<String, String> sortParams);
    List<Movie> getRandom(int randomCount);
    List<Movie> getMoviesByGenre(int genreId,LinkedHashMap<String, String> sortParams);
}
