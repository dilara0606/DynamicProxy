package com.DynamicProxy.Animal.service.impl;

import com.DynamicProxy.Animal.entity.Animal;
import com.DynamicProxy.Animal.service.AnimalService;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Override
    public void performActions(Animal animal) {
        animal.speak();
        animal.eat("food");
    }
}
