package com.example.mykotlindemo.entity.mode;

public class SingletonDemo1 {


    private static SingletonDemo1 singletonDemo1;
    private SingletonDemo1(){}

    public static SingletonDemo1 getInstance() {
        if (singletonDemo1 == null) {
            synchronized (SingletonDemo1.class) {
                if (singletonDemo1 == null) {
                    singletonDemo1 = new SingletonDemo1();
                }
            }
        }
        return singletonDemo1;
    }
}
