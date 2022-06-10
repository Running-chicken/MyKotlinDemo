package com.example.mykotlindemo.entity;

public class TestGC {

    public static void main(String[] args) {
        TestGC t1 = new TestGC();
        TestGC t2 = new TestGC();

        t1 = null;
        System.gc();

        t2 = null;
        Runtime.getRuntime().gc();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("before gc");
        System.out.println("before gc"+this);
    }
}
