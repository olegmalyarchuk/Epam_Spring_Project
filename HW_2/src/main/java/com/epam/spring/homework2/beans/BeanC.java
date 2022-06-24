package com.epam.spring.homework2.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class BeanC extends OurBean{

    public void doInit() {
        System.out.println("Initiating BeanC");
    }

    public void doDestroy() {
        System.out.println("Destroying Bean C");
    }


    public BeanC() {

    }

    public BeanC(String name, int value) {
       super(name, value);
    }


}
