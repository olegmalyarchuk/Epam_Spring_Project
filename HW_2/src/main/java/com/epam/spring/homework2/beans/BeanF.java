package com.epam.spring.homework2.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanF extends OurBean {

    public BeanF() {

    }

    public BeanF(String name, int value) {
        super(name, value);
    }

}
