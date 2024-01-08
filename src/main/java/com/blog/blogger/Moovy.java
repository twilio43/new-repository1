package com.blog.blogger;

public class Moovy{
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

    public Moovy(String name, int rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

}
