package com.blog.blogger;

import java.util.Comparator;

public class MoovyName implements Comparator<Moovy> {
    @Override
    public int compare(Moovy o1, Moovy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
