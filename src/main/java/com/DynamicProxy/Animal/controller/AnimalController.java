package com.DynamicProxy.Animal.controller;

import com.DynamicProxy.Animal.entity.Animal;
import com.DynamicProxy.Animal.proxy.AnimalInvocationHandler;
import com.DynamicProxy.Animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/perform")
    public void performActions() {
        Animal dog = (Animal) Proxy.newProxyInstance(
                Animal.class.getClassLoader(),
                new Class[] { Animal.class },
                new AnimalInvocationHandler(new Dog())
        );

        animalService.performActions(dog);
    }

    class Dog implements Animal {

        @Override
        public void speak() {
            System.out.println("Woof!");
        }

        @Override
        public void eat(String food) {
            System.out.println("Dog eats " + food);
        }
    }
}
