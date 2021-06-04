package com.aloli.security.arithmetic;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {

        //i 右移动   J 左边移动  i++ j--  j寻小  i寻大
        //j找到  j位置替换    然后i在找比这个大数目替换j

        int[] x = {45,32,12,55,88,22,76,45,33};
        bubllingSort(x);
        //quickSort(x,0,x.length-1);
        Arrays.stream(x).forEach(a->{
            System.out.print(a+"  ");
        });
        System.out.println(x.toString());


    }


    public static  void quickSort(int[] arr ,int l,int r) {
        if (l < r) {
            int x = arr[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                }
            }
            arr[i] = x;

            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }


    public static void bubllingSort(int [] arr){
        int temp;

        for(int i=0;i<arr.length-1;i++){
            int flag=0;
            for(int j=0;j<arr.length-1-i;j++){

                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag=1;
                }
            }
            if(flag==0){
                return ;
            }
        }
    }




}
