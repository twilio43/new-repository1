package com.blog.blogger;

public class Movie implements Comparable<Movie>{
    //Comparable interface has 1 drawback you can sort either based on any one parameter.
    private String name;
    private  int rating;
    private int year;

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public Movie(String name, int rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.name.compareTo(o.name);
    }

//    @Override
//    public int compareTo(Movie o) {
//        return this.rating-o.rating;
//    }

//    @Override
//    public int compareTo(Movie o) {
//        return this.year-o.year;
//    }
}
