package com.epam.spring.homework2.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class BeanD extends OurBean {

    public BeanD() {
    }

    public BeanD(String name, int value) {
        super(name, value);

    }

    public void doInit() {
        System.out.println("Initiating BeanD");
    }

    public void doDestroy() {
        System.out.println("Destroying Bean D");
    }

}
