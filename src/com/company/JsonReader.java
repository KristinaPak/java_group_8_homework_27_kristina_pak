package com.company;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonReader {
    private static Gson gson = new Gson();

    public static List<Movie> getMovies() throws IOException {

        try (Reader reader = new FileReader("movies.json")) {
            Movie[] movies = gson.fromJson(reader, Movie[].class);
            ArrayList<Movie> movie = new ArrayList<>();
            for (Movie m : movies){
                movie.add(m);
            }

            return movie;
        }
    }


    public static List<Cast> getCast() throws IOException {
        try (Reader reader = new FileReader("cast.json")) {
            Cast[] casts = gson.fromJson(reader, Cast[].class);
            ArrayList<Cast> casts1 = new ArrayList<>();
            for (Cast c : casts1){
                casts1.add(c);
            }

            return casts1;
        }
    }

    public static Cast[] readFileTwo(String fileName) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader(fileName)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            Cast[] casts = new Cast[jsonArray.size()];
            Integer q = 0;
            for (Object o : jsonArray) {
                JSONObject fact = (JSONObject) o;

                casts[q] = new Cast(
                        (String) fact.get("fullName"),
                        (String) fact.get("role"));
                q=q+1;
            }
            return casts;

        }
    }
}
