package com.alexa.movieland.web.controller;

import com.alexa.movieland.dao.mapper.GenreMapper;
import com.alexa.movieland.entity.Genre;
import com.alexa.movieland.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/genres")
public class GenreController {
    private GenreService genreService;
    private long startTime = System.currentTimeMillis();

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAll(){
        List<Genre> all = genreService.getAll();
        log.info("Getting all genres in {} ms: ", System.currentTimeMillis()-startTime);
        return all;
    }
}
