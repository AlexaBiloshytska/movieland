package com.alexa.movieland.entity;

import lombok.Data;

@Data
public class Movie {
    private int id;
    private String nameNative;
    private String nameRussian;
    private int yearOfRelease;
    private String description;
    private double rating;
    private double price;
    private String posterUrl;
}
