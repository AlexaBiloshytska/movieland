package com.alexa.movieland.web.dto;

import lombok.Data;

@Data
public class MovieLto {
    private int id;
    private String nameNative;
    private String nameRussian;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String posterUrl;
}
