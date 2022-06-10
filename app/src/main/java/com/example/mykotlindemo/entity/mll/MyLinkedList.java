package com.example.mykotlindemo.entity.mll;

public class MyLinkedList {

    private Node head;

    private int size;

    public MyLinkedList(){
        this.head = new Node();
        this.size = 0;
    }

    public boolean add(Integer item){
        Node newNode = new Node(item,null);
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        size++;
        return true;
    }

    public Integer get(int index){
        checkIndex(index);
        Node node = getNode(index);
        return node.item;
    }

    private void checkIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }

    //数据结构 head不存值
    private Node getNode(int index){
        Node temp = head;
        for(int i=0; i<=index; i++){
            temp = temp.next;
        }

        return temp;
    }



    public Integer remove(int index){
        this.checkIndex(index);
        Node node = this.getNode(index);
        Integer value = node.item;
        node.item = null;

        node.prev.next = node.next;
        if(node.next!=null){
            node.next.prev = node.prev;
        }
        node.next=null;
        node.prev=null;
        size--;
        return value;
    }


    public void list(){
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
            System.out.println(temp.item+" ");
        }
    }


    private static class Node{
        private Integer item;
        private Node prev;
        private Node next;
        public Node(){

        }

        public Node(Integer item,Node next){
            this.item = item;
            this.next = next;
        }



    }
}
