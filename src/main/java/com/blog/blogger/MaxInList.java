package com.blog.blogger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class MaxInList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 100, 200, 5900, 10004532, 9000);
        Integer i = numbers.stream().max(Integer::compare).get();
        System.out.println("The maximum number is:"+i);
    }
}