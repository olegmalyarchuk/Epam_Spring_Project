package com.epam.spring.homework2.bpp;

import com.epam.spring.homework2.beans.BeanA;
import com.epam.spring.homework2.beans.OurBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorA implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean isOurBean = bean instanceof OurBean;
        if(isOurBean) {
            if(((OurBean) bean).getName()==null|| ((OurBean) bean).getValue() < 0) {
                System.out.println("Bean isn't valid");
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
