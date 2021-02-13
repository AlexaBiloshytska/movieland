package com.alexa.movieland.dao;

import com.alexa.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();
}
