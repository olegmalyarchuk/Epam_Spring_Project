package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanA;
import com.epam.spring.homework1.beans.BeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanC {
    @Autowired
    private BeanC beanC;

    OtherBeanC() {
        System.out.println(beanC); //null because the constructor is called earlier than injection
    }
}
