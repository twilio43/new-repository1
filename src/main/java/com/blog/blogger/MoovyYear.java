package com.blog.blogger;

import java.util.Comparator;

public class MoovyYear implements Comparator<Moovy> {

    @Override
    public int compare(Moovy o1, Moovy o2) {
        return o1.getYear()-o2.getYear();
    }
}
