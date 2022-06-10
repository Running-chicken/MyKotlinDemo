package com.example.mykotlindemo.entity.mode;

public class SingletonDemo {

    private SingletonDemo(){}
    private static SingletonDemo singletonDemo = new SingletonDemo();

    public static SingletonDemo getInstance(){
        return singletonDemo;
    }

}
