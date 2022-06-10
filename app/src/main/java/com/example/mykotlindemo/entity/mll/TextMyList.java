package com.example.mykotlindemo.entity.mll;

public class TextMyList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(100);
        list.add(1);
        list.add(2);
        list.add(90);
        list.add(78);
        list.add(22);
        list.remove(0);
        list.list();
    }
}
