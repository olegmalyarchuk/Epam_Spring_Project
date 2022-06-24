package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Import(ConfigA.class)
@PropertySource("classpath:application.properties")
public class ConfigB {
    @Autowired
    public Environment environment;

    @Bean(initMethod = "doInitA", destroyMethod = "doDestroy")
    @DependsOn("beanC")
    public BeanB beanB() {
        return new BeanB(environment.getProperty("beanB.name"), Integer.valueOf(environment.getProperty("beanB.value")));
    }
    @Bean(initMethod = "doInit", destroyMethod = "doDestroy")
    @DependsOn("beanD")
    public BeanC beanC() {
        return new BeanC(environment.getProperty("beanC.name"), Integer.valueOf(environment.getProperty("beanC.value")));
    }
    @Bean(initMethod = "doInit", destroyMethod = "doDestroy")
    public BeanD beanD() {
        return new BeanD(environment.getProperty("beanD.name"), Integer.valueOf(environment.getProperty("beanD.value")));
    }
}
