package com.blog.blogger;

import java.util.ArrayList;
import java.util.Collections;


public class MainMoovy {
    public static void main(String[] args) {
        Moovy m1=new Moovy("bbb",6,1999);
        Moovy m2=new Moovy("aaa",8,1986);
        Moovy m3=new Moovy("ccc",5,2000);

        //must use ArrayList
        //using Comparable we can sort based on only one option, but using Comparator interface we can sort based on all options.
        ArrayList<Moovy> list=new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        MoovyName moovyName=new MoovyName();
        Collections.sort(list,moovyName);

        for (Moovy m:list) {
            System.out.println(m.getName());
            System.out.println(m.getYear());
            System.out.println(m.getRating());

        }
    }
}
