package com.example.mykotlindemo.entity.threa;

public class TestSync {

    static int a = 1;
    static int flag=1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<101){
                    if(flag==1){
                        synchronized (TestSync.class){
                            System.out.println("t1 out:"+a);
                            a++;
                            flag=2;
                        }
                    }

                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<100){
                    if(flag==2){
                        synchronized (TestSync.class){
                            System.out.println("t2 out:"+a);
                            a++;
                            flag=3;
                        }
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<100){
                    if(flag==3){
                        synchronized (TestSync.class){
                            System.out.println("t3 out:"+a);
                            a++;
                            flag=1;
                        }
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
