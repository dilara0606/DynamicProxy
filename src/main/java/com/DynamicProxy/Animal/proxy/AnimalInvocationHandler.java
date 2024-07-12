package com.DynamicProxy.Animal.proxy;

import com.DynamicProxy.Animal.entity.Animal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalInvocationHandler implements InvocationHandler {

    private final Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(animal, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}
