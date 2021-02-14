package com.alexa.movieland.web.controller;

import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.service.MovieService;
import com.alexa.movieland.web.dto.MovieLto;
import com.alexa.movieland.web.mapper.MovieMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class MovieControllerTest {
    private Movie movie;
    private MovieService service = mock(MovieService.class);
    private MovieController controller;
    private MovieMapper movieMapper = mock(MovieMapper.class);

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        controller = new MovieController(service,movieMapper);
        movie = new Movie();
        movie.setId(1);
        movie.setNameNative("native");
        movie.setNameRussian("russian");
        movie.setDescription("description");
        movie.setYearOfRelease(2009);
        movie.setPosterUrl("www.poster.com");
        movie.setRating(9.5);
        movie.setPrice(200.1);
    }


    @Test
    public void getAll() {
        when(service.getAll(new LinkedHashMap<>())).thenReturn(Arrays.asList(movie));
        List<MovieLto> actual = controller.getAll(new LinkedHashMap<>());

        assertNotNull(actual);
        assertEquals(1, movie.getId());
        assertEquals("native", movie.getNameNative());
        assertEquals("russian", movie.getNameRussian());
        assertEquals(2009, movie.getYearOfRelease());
        assertEquals("www.poster.com", movie.getPosterUrl());
        assertEquals("description", movie.getDescription());
        assertEquals(9.5, movie.getRating(), 0.00);
        assertEquals(200.1, movie.getPrice(), 0.00);
    }

    @Test
    public void getRandom() {
    }

    @Test
    public void getMoviesByGenre() {
    }

    @Test
    public void getMovieById(){
        int id = 1;
        when(service.getMovieById(id)).thenReturn(movie);
        Movie movieById = controller.getMovieById(id);

        assertNotNull(movieById);
        assertEquals(1, movie.getId());
        assertEquals("native", movie.getNameNative());
        assertEquals("russian", movie.getNameRussian());
        assertEquals(2009, movie.getYearOfRelease());
        assertEquals("www.poster.com", movie.getPosterUrl());
        assertEquals("description", movie.getDescription());
        assertEquals(9.5, movie.getRating(), 0.00);
        assertEquals(200.1, movie.getPrice(), 0.00);
    }
}