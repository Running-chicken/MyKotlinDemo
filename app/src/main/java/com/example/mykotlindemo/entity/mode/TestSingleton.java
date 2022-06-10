package com.example.mykotlindemo.entity.mode;

public class TestSingleton {


    public static void main(String[] args) {
        for(int i=0;i<3;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println("singleton:"+SingletonDemo.getInstance().hashCode());;
                }
            }).start();
        }
    }

}
