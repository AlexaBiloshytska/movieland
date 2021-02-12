package com.alexa.movieland.dao.mapper;

import com.alexa.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {

        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameNative(resultSet.getString("name_native"));
        movie.setNameRussian(resultSet.getString("name_russian"));
        movie.setYearOfRelease(resultSet.getInt("year_of_release"));
        movie.setDescription(resultSet.getString("description"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPosterUrl(resultSet.getString("poster_url"));

        return movie;
    }

}
