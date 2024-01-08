package com.blog.blogger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainEmp {
    public static void main(String[] args) {
        List<Employee> emp= Arrays.asList(new Employee("mike",5000),
                                          new Employee("stallin",10000),
                                          new Employee("adan",10000));
        Map<Double, List<Employee>> collect = emp.stream().collect(Collectors.groupingBy(Employee::getSalary));
        for (Map.Entry<Double,List<Employee>> groups:collect.entrySet())
              {
                  double key = groups.getKey();
                  List<Employee> value = groups.getValue();
                  System.out.println("The list of employees with salary:"+key+";");
                  for (Employee e:value)
                        {
                            System.out.println("  "+e.getName());
                  }
              }
    }
}
