package com.alexa.movieland.service;

import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.entity.SortingEnum;

import java.util.List;

public interface MovieService {
List<Movie> getAll(List<SortingEnum> sortParams);
    List<Movie> getRandom();
    List<Movie> getMoviesByGenre(int genreId,List<SortingEnum> sortParams);
}
