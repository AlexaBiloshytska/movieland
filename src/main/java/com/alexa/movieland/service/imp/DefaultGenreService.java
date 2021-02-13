package com.alexa.movieland.service.imp;

import com.alexa.movieland.dao.GenreDao;
import com.alexa.movieland.entity.Genre;
import com.alexa.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultGenreService implements GenreService {
    private GenreDao genreDao;

    @Autowired
    public DefaultGenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }


    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }


}
