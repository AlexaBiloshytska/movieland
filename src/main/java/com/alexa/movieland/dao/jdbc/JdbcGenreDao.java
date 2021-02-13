package com.alexa.movieland.dao.jdbc;

import com.alexa.movieland.dao.GenreDao;
import com.alexa.movieland.dao.mapper.GenreMapper;
import com.alexa.movieland.entity.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Slf4j
public class JdbcGenreDao implements GenreDao {
    private static final String GET_ALL = "select * from genres";
    private GenreMapper genreMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(GenreMapper genreMapper, JdbcTemplate jdbcTemplate) {
        this.genreMapper = genreMapper;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Genre> getAll() {
        long startTime = System.currentTimeMillis();
        List<Genre> query = jdbcTemplate.query(GET_ALL, genreMapper);
        log.info("Getting all movies in {} ms: ",System.currentTimeMillis()-startTime);
        return query;
    }
}
