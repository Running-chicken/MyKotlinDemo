package com.example.mykotlindemo.entity.suanf;

import java.util.Arrays;

public class TestSf {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        reverse(array,1,4);
    }

    public static void reverse(int[] a,int begin,int end){
        int b[] = new int[a.length];
        int j=0;
        for(int i=0;i<a.length;i++){
            if(i<begin || i > end){
                b[i] = a[i];
            }else{
                b[i] = a[end-j];
                j++;
            }
        }
        System.out.println("out:"+Arrays.toString(b));
    }

}
