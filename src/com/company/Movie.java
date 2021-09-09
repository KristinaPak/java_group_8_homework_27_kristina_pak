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

    public Cast[] getCasts() {
        return casts;
    }

    public void setCasts(Cast[] casts) {
        this.casts = casts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public String getDirectorName() {
        return director.getName();
    }


    public void setDirector(Director director) {
        this.director = director;
    }

    public Cast[] getCast() {
        return casts;

    }
}
