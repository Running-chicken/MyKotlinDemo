package com.example.mykotlindemo.entity.threa;

public class TestVoli {


    static volatile int a=1;
    static volatile int flag=1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<101){
                    if(flag==1){
                        System.out.println("t1 "+a);
                        a++;
                        flag=2;
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<101){
                    if(flag==2){
                        System.out.println("t2 "+a);
                        a++;
                        flag=3;
                    }

                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<101){
                    if(flag==3){
                        System.out.println("t3 "+a);
                        a++;
                        flag=1;
                    }

                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
