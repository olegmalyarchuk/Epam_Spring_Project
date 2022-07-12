package com.epam.spring.homework2.config.bpp;

import com.epam.spring.homework2.beans.BeanB;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		factory.getBeanDefinition("BeanBName").setInitMethodName("anotherInitBeanB");
		System.out.println("CustomBeanFactoryPostProcessor: postProcessBeanFactory()");
	}
}
