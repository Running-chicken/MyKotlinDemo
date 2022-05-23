package com.example.mykotlindemo.test;

import java.util.Arrays;

public class SortDemo {

    public static void main(String[] args) {
        int[] array = new int[]{67,3,23,38,2,90,74};

//        insertSort(array);
//        shellSort(array);
//        simpleSort(array);
//        heapSort(array);
//        bubbleSort(array);
//        quickSort(array);
//        mergeSort(array);
        radixSort(array);

//        int[] order = new int[10];
//        System.out.println(Arrays.toString(order));
//        System.out.println("this is:"+order[5]);

    }


    //插入排序： 每次都把最小的值放到第一位
    static void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j=i-1;
            for(;j>=0 && a[j]>temp;j--){ //每个值都和temp比较，大于temp就后移
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }

        System.out.println("insert:"+Arrays.toString(a));

    }


    //希尔排序 分组 - 插入排序
    static void shellSort(int[] a){
        for(int d = a.length/2; d>0; d=d/2){ //设置增量为d 根据d分组，
            //分组 8个数 d=4 [0,4] [1,5] [2,6][3,7] 4个分组
            //7个数 d=3 [0,3,6][1,4][2,5] 3个分组
            //6个数 d=3 [0,3][1,4][2,5]
            for(int x=0; x<d; x++){  //分组
                //以下内容是插入排序 只是增加了步长d
                for(int i=x+d; i<a.length; i+=d){
                    int temp = a[i];
                    int j = i-d;
                    for(; j>=0 && a[j]>temp ; j-=d){
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;
                }
            }
        }
        System.out.println("shell:"+Arrays.toString(a));
    }

    //简单选择 找最小
    static void simpleSort(int[] a){
        for(int i=0; i<a.length; i++){

            int temp = a[i];
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<temp){
                    temp = a[j];
                    min = j;
                }
            }
            a[min] = a[i];
            a[i] = temp;
        }
        System.out.println("simple:"+Arrays.toString(a));
    }


    //堆排序 找最大
    static void heapSort(int[] a){
        //最后一个非叶子节点  （最后元素位置-1） /2
        int startIndex = a.length/2-1;
        //从最后一个非叶子节点开始往前 一组组对比 每组父节点都是最大值
        for(int i=startIndex;i>=0;i--){
            maxHeap(a,a.length,i);
        }
        //以上操作后 最大值就是第一个元素
        for(int i=a.length-1; i>0; i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            //此时最大值已取出 最后一位已经到顶端 直接从这排序 因为底下已经排好了
            maxHeap(a,i,0);
        }

        System.out.println("堆排序："+Arrays.toString(a));
    }

    /**
     * 该方法就是 进行 父和两子的比较 取最大值
     * 调整后 再把子和孙去比 ...
     * @param a  数组
     * @param heapSize  数组长度
     * @param index  当前父节点位置
     */
    static void maxHeap(int[] a,int heapSize,int index){
        int left = index*2+1;
        int right = index*2+2;
        int largest = index;
        if(left<heapSize && a[index]<a[left]){
            largest = left;
        }
        if(right<heapSize && a[largest]<a[right]){
            largest = right;
        }
        if(largest!=index){
            int temp = a[index];
            a[index] = a[largest];
            a[largest] = temp;
            maxHeap(a,heapSize,largest); //交换后 虽然父节点已经变最大值 但是子节点还要和自己的子节点再去对比
        }

    }

    //冒泡 从最后一位开始 往上冒
    static void bubbleSort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=a.length-2; j>=i ; j--){
                if(a[j+1]<a[j]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("bubble:"+Arrays.toString(a));
    }

    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }


    //快速排序 找基数  小于基数在左 大于在右
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = pivot;
            quickSort(array, left, low - 1);
            quickSort(array, low + 1, right);
        }
    }

    //归并排序 把数据分成一组一组 到最小单位 再合并
    static void mergeSort(int[] a){
        mergeSort(a,0,a.length-1);
        System.out.println("merge:"+Arrays.toString(a));
    }

    static void mergeSort(int[] a,int left,int right){
        if(left<right){
            int center = (left+right)/2;
            mergeSort(a,left,center); //前半部分归并  内部再拆分 再归并
            mergeSort(a,center+1,right); //后半部分归并
            merge(a,left,center,right); //前两步完成后 组成两个大数组 再合并
        }
    }

    static void merge(int[] a,int left,int center,int right){
        int[] tempArray = new int[a.length];
        int middle = center+1;
        int newIndex = left;//新数组索引
        int oldIndex = left;//老数组索引
        while (left<=center && middle<=right){ //分别从前后数组取最小值到新数组中
            if(a[left] <= a[middle]){
                tempArray[newIndex++] = a[left++];//前数组取值 索引++
            }else{
                tempArray[newIndex++] = a[middle++];//后数组取值 索引++
            }
        }
        while (left<=center){ //此时后半数组已经没了
            tempArray[newIndex++] = a[left++];
        }
        while (middle<=right){ //此时前半数组已经没了
            tempArray[newIndex++] = a[middle++];
        }
        while (oldIndex<=right){
            a[oldIndex] = tempArray[oldIndex++];
        }

    }


    static void radixSort(int[] a){
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        //最大值位数 个1 十2 百3 千4
        int time = 0;
        while (max>0){
            max/=10;
            time++;
        }

        //当前位数 1个位 2十位 3百位
        int m = 1;
        int n = 1;//对应 1  10  100 1000 用来求余
        int k = 0;//新数组坐标

        //数组temp的第一维表示该位数值，二维表示每个值的长度 ps: 有可能所有值尾数都是一个值
        int[][] temp = new int[10][a.length];
        //数组order用来记录每个值上的元素个数
        int[] order = new int[10];

        while (m<=time){//1个位 2十位 3百位
            for(int num : a){
                int lsd = (num/n) % 10;//数组值/n后 再求余数
                temp[lsd][order[lsd]] = num; //例如5：  1维度：数值为5的数组   2维度：记录5数组内数值个数 首次：temp[5][0]=5
                order[lsd]++; //数值5对应数组 元素个数+1
            }

            //根据位数 从小到大排序
            for(int i=0;i<10;i++){
                if(order[i]!=0){//判断记录数组对应数值个数是否=0
                    for(int j=0;j<order[i];j++){//遍历记录数组 每个值的个数 只要个数大于0
                        a[k] = temp[i][j]; //基于m位(1个位 2十位 3百位)的重新放入数组中
                        k++;
                    }

                }
                order[i] = 0;//将对应i数值记录数清0
            }

            //排序后 升级位数  m1个位-》2十位   n=1 -》n=10 ,数组坐标归零
            m++;
            n*=10;
            k=0;

            System.out.println("radix:"+Arrays.toString(a));
        }


    }



}

