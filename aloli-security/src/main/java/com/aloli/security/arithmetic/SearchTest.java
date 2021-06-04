package com.aloli.security.arithmetic;

public class SearchTest {



    //二分查找
    public static void main(String[] args) {


       int[]  arr = {3,12, 24, 31, 46, 48, 52, 66, 69, 79, 82};

        System.out.println("位置"+binarySearch(arr,20));
    }



    public static  int binarySearch(int[] arr,int target){

        int left =0;
        int right=arr.length-1;
        int mid = (left+arr.length-1)/2;
        //7 3
        while(left<=right){
            // left = 1   right = 2
            // 相互除=  1 / 2 = 1
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                right = mid-1;  // 如果不-1
                // 那么   mid 会一直被计算到
                // 即  left 1 (13) right  2(24)  1/2 = 1  13  要找20
                // 那么 13会一直比20小  即 left 要转到mid   然他变大
                // 而 1/2=1  即  left 会一直等于1  一直循环
            }
            if(arr[mid]<target){
                left=mid+1;
            }
            mid=(left+right)/2;//1+2/2 = 1

            System.out.println("mid:"+mid+"left:"+left+"right:"+right);
        }
        return -1;
    }




}
