package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Homework1Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        Pet pet = context.getBean(Pet.class);
        pet.printPets();

        //By type
        //We will get it by @Primary without exceptions
        Cheetah cheetahA = context.getBean(Cheetah.class);
        //By name
        Cheetah cheetahB = context.getBean("cheetahB", Cheetah.class);
        System.out.println(cheetahA);
        System.out.println(cheetahB);
    }

}
