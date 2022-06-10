package com.example.mykotlindemo.entity.meican;

public class TestBalance {


    public static void main(String[] args) {
//        fun1();
        fun2();
    }


    public static void fun1(){
        int[] a= new int[]{1,1,1,1,5,1,1,1,1};

        int result=-1;
        int i=0;
        int m=a[i];
        int j=a.length-1;
        int n=a[j];
        while (i<j){
            if(m==n && j-i==2){
                result=i+1;
                break;
            }
            if(m<n){
                i++;
                m+=a[i];
            }else{
                j--;
                n+=a[j];
            }
        }
        System.out.println("result="+result);
    }

    public static void fun2(){
        int[] a= new int[]{1,1,1,1,5,1,1,1,1};
        int result =-1;
        int sum=0;
        int count=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        for(int i=0;i<a.length;i++){
            if(count == (sum-count-a[i])){
                result=i;
                break;
            }else{
                count+=a[i];
            }
        }


        System.out.println("result="+result);
    }
}
