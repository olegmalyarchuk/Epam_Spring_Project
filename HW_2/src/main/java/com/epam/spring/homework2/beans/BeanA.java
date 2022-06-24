package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA extends OurBean implements InitializingBean, DisposableBean {


    public BeanA() {
        super();
    }

    public BeanA(String name, int value) {
        super(name, value);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying BeanA");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Calling afterPropertiesSet()");
    }

}
