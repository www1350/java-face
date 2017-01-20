package com.absurd.sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *
 */
public class Sort {
    private int [] array;
    public Sort(int[] array){
        this.array = array;
    }
    private AtomicInteger count = new AtomicInteger(0);
    private Set<Integer> lightIndex  = new HashSet<Integer>();

    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }


    public void display(int k){
        for(int i=0;i<array.length;i++){
            if (i==k)
                System.out.print("|"+array[i]+"|\t");
            else
                System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    public void display(Set set){
        for(int i=0;i<array.length;i++){
            if (set.contains(i))
                System.out.print("|"+array[i]+"|\t");
            else
                System.out.print(array[i]+"\t");
        }
        System.out.println();
    }


    /***
     * 冒泡排序
     */
    public void bubbleSort(){
        int temp;
        int length = array.length;
        System.out.println();
        for(int i=0;i<length-1;i++){
            for(int j=1;j<length-i;j++){
                if(array[j]>array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
            System.out.print("第"+(i+1)+"轮排序:");  display();
        }
        System.out.println();
    }


    /***
     * 冒泡排序改进1
     */
    public void bubbleSort_improve(){
        int temp;
        int length = array.length;

        System.out.println();
        for(int i=0;i<length-1;i++){
            boolean flag = false;
            for(int j=1;j<length-i;j++){
                if(array[j]>array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                  if (!flag) flag = true;
                }
            }
            if (!flag) break;
            System.out.print("第"+(i+1)+"轮排序:");  display();
        }
        System.out.println();
    }

    /***
     * 快排
     */
    public void quickSort(){
        quickSort(array,0,array.length-1);
    }


    private void quickSort(int[] arr, int l, int r) {
        if (l<r){
         int i =   findPoint(arr,l,r);
            quickSort(arr,l,i-1);
            quickSort(arr,i+1,r);
        }
    }

    private int findPoint(int[] arr, int l, int r) {
        int i=l,j=r,k=arr[l];
        while(i<j){
            while(i<j&&arr[j]<k)
                j--;
            if (i<j)
                arr[i++] = arr[j];
            while (i<j&&arr[i]>=k)
                i++;
            if (i<j)
                arr[j--]=arr[i];
        }
        arr[i] = k;
        lightIndex.add(i);
        System.out.print("第"+count.incrementAndGet()+"轮排序(k="+k+")(i="+i+"):");  display(lightIndex);
        return i;
    }


    /****
     * 插入排序
     */
    public void insertionSort(){
        int length = array.length;
        int temp;
        for(int i=0;i<length-1;i++){
            for(int j=i;j>=0;j--){
                if (array[j+1]>array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
            lightIndex.add(i);
            System.out.print("第"+(i+1)+"轮排序:");  display(lightIndex);
        }



    }

}
