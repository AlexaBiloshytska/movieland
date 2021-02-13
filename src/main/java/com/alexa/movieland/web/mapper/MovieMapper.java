package com.alexa.movieland.web.mapper;

import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.web.dto.MovieLto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieLto map(Movie movie) {
        MovieLto movieLto = new MovieLto();

        movieLto.setId(movie.getId());
        movieLto.setNameNative(movie.getNameNative());
        movieLto.setNameRussian(movie.getNameRussian());
        movieLto.setYearOfRelease(movie.getYearOfRelease());
        movieLto.setRating(movie.getRating());
        movieLto.setPrice(movie.getPrice());
        movieLto.setPosterUrl(movie.getPosterUrl());

        return movieLto;
    }

    public List<MovieLto> map(List<Movie> movies){
        List<MovieLto> ltoList = new ArrayList<>();

        for (Movie movie : movies) {
            MovieLto movieLto = map(movie);
            ltoList.add(movieLto);
        }
        return ltoList;
    }
}
