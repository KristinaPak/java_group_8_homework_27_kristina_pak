package com.company;

public class Movie {
    protected String name;
    public Integer year;
    private String description;
    protected Director director;
    private Cast[] casts;

    public Movie(String name, Integer year, String description, Director director, Cast[] casts) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.casts = casts;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public String getDirectorName() {
        return director.getName();
    }

    }
