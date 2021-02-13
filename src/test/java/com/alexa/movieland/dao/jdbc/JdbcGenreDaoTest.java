package com.alexa.movieland.dao.jdbc;

import com.alexa.movieland.dao.GenreDao;
import com.alexa.movieland.entity.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
public class JdbcGenreDaoTest {

    @Autowired
    private GenreDao genreDao;

    @Test
    public void getAll() {
        List<Genre> genres = genreDao.getAll();
        Assert.assertEquals(2,genres.size());
    }
}