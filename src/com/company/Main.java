package com.company;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("                        -----------Коллекция фильмов-----------");
        List<Movie> movies = JsonReader.getMovies();
        for (Movie m : movies) {
            String frm = "|%-42s|%-6s|%-10s|%-20s|";
            System.out.println(String.format(frm, m.getName(), m.getYear(), m.getDescription(), m.getDirectorName()));
        }
        System.out.println();
        System.out.print("Введите название фильма(возможно частичное совпадение): ");
        String find = sc.nextLine();
        for (Movie m : movies) {
            if (m.getName().indexOf(find) != -1) {
                System.out.println("Ваш фильм: " + m.getName());
            }
        }
        System.out.println();
        System.out.println("-----------------------------Сортировка по возрастанию (год выпуска)-------------------------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.year.compareTo(o2.year);
            }
        });
        for (Movie m : movies) {
            String fm = "%-20s|%-10s|%-42s|";
            System.out.println(String.format(fm, " ", m.getYear(), m.getName()));

        }
        System.out.println();
        System.out.println("-----------------------------Сортировка по убыванию (год выпуска)-----------------------------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o2, Movie o1) {
                return o1.year.compareTo(o2.year);
            }
        });
        for (Movie m : movies) {
            String fm = "%-20s|%-10s|%-42s|";
            System.out.println(String.format(fm, " ", m.getYear(), m.getName()));
        }
        System.out.println();
        System.out.println("-----------------------------Сортировка по возрастанию (название)-----------------------------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Movie m : movies) {

            String fm = "%-20s|%-42s|";
            System.out.println(String.format(fm, " ", m.getName()));
        }
        System.out.println();
        System.out.println("-----------------------------Сортировка по убыванию (название)-----------------------------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o2, Movie o1) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Movie m : movies) {
            String fm = "%-20s|%-42s|";
            System.out.println(String.format(fm, " ", m.getName()));
        }
        System.out.println();
        System.out.println("-----------------------------Сортировка по возрастанию (имена режиссеров)-----------------------------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.director.compareTo(o2.director);
            }
        });
        for (Movie m : movies) {
            String fm = "%-20s|%-20s|%-42s|";
            System.out.println(String.format(fm, " ", m.getDirector().getName(), m.getName()));
        }
        System.out.println();
        System.out.println("-----------------------------Сортировка по убыванию (имена режиссеров)-----------------------------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o2, Movie o1) {
                return o1.director.getName().compareTo(o2.director.getName());
            }
        });
        for (Movie m : movies) {
            String fm = "%-20s|%-20s|%-42s|";
            System.out.println(String.format(fm, " ", m.getDirector().getName(), m.getName()));
        }


        System.out.println();
        System.out.println("+--------Имена актеров--------+");
        Cast[] casts = new Cast[0];
        try {
            casts = JsonReader.readFileTwo("cast.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (Cast cast : casts) {
            printCast(cast);
        }
        System.out.print("Введите имя актера: ");
        String name = sc.nextLine();
        for (Cast cast : casts) {
            if (cast.getFullName().indexOf(name) != -1) {
                System.out.println("Роль: " + cast.getRole());
            }
        }
        System.out.println("--------Режиссеры--------- ");
        for (Movie m : movies) {
            System.out.println(m.getDirectorName());
        }
        System.out.println();
        System.out.print("Введите имя: ");
        String dir = sc.nextLine();
        for (Movie m : movies) {
            if (m.getDirectorName().indexOf(dir) != -1) {
                System.out.println("Фильм снятый: " + m.getName());
            }
        }
        System.out.println("--------Года--------");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o2, Movie o1) {
                return o1.year.compareTo(o2.year);
            }
        });
        for (Movie m : movies) {
            System.out.println(m.getYear());
        }
        System.out.println();
        System.out.println("Введите год: ");
        int year = sc.nextInt();
        for (Movie m : movies) {
            if (m.getYear().equals(year)) {
                System.out.println(m.getName());
            }
        }

        System.out.println();
        System.out.println("+----------Все актеры и их роли-----------+");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.director.getName().compareTo(o2.director.getName());
            }
        });
        for (Cast с : casts) {
            String f = "|%-20s|%-20s|";
            System.out.println(String.format(f, с.getFullName(), с.getRole()));
        }
        System.out.println();
    }

    private static void printCast(Cast cast) {
        System.out.println(cast.getFullName());
    }
}