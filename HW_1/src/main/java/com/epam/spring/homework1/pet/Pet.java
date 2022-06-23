package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pet {
    @Autowired
    List<Animal> animalList;

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public void printPets() {
        animalList.forEach(animal -> System.out.println(animal.getClass().getSimpleName()));
    }
}
