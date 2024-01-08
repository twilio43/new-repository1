package com.blog.blogger;

import java.util.ArrayList;
import java.util.Collections;

public class MainMovie {
    public static void main(String[] args) {
        Movie m1=new Movie("bbb",6,1999);
        Movie m2=new Movie("aaa",8,1986);
        Movie m3=new Movie("ccc",5,2000);
        //To sort movie based on name or rating or year we have two ways :-Comparator and Comparable
        //must use ArrayList
        //using Comparable we can sort based on only one option, but using Comparator interface we can sort based on all options.
        ArrayList<Movie> list=new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        Collections.sort(list);//it will call compareTo method of movie class
        for (Movie m:list) {
            System.out.println(m.getName());
            System.out.println(m.getYear());
            System.out.println(m.getRating());

        }
    }
}
