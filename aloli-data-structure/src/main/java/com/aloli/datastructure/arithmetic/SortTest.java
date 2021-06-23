package com.aloli.datastructure.arithmetic;

import java.util.Arrays;

/**
 * 排序算法
 */
public class SortTest {

    public static void main(String[] args) {

        //i 右移动   J 左边移动  i++ j--  j寻小  i寻大
        //j找到  j位置替换    然后i在找比这个大数目替换j

        int[] x = {45,32,12,55,88,22,76,45,33};
        //bubllingSort(x);

        //selectionSort(x);
        //insertionSort(x);
        //shellSort(x);
        quickSort(x,0,x.length-1);
        //quickSort(x,0,x.length-1);

        //preHeapSort(x);
        Arrays.stream(x).forEach(a->{
           System.out.print(a+"  ");
        });


    }

    //==================================================
    /**
     * 希尔排序   插入排序的增强版
     * 先将整个待排序的记录序列 分割成若干子序列 分别进行直接插入排序
     * 待整个序列种的记录基本有序时 再对全体记录进行直接插入排序
     */

    private static  void  shellSort(int[] arr){
        int length = arr.length;
        int temp;
        //步长   先  分步
        //

        //分步  10个  5
        for (int step = length / 2; step >= 1; step /= 2) {
            //5- len次
            for (int i = step; i < length; i++) {
                //5
                temp = arr[i];
               //5-5=0
                int j = i - step;
                //当
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    //=========================================================
    /**
     * 插入排序
     * 将第一个看成有序  将第二个到最后一个未排序的看成无序
     *  第I 个 循环和前面进行对比   如果小于前面的  就交换顺序
     */
    private static void insertionSort(int [] arr){
        //堆的次数
        for(int i = 1;i<arr.length;i++){
            //获取到 当前需要排序的 值的位置
            int temp=arr[i];

            //从右边开始比较  如果 小于他 则交换位置
            int j = i;

            while(j>0&&arr[j-1]>temp){
                arr[j]=arr[j-1];
               j--;
            }

            arr[j]=temp;
        }
    }




    //==========================================================
    /**
     * 冒泡排序
     * 走arr len 趟
     *   循环arr len -i 趟
     * 如果右边大于左边 则交换
     *
     * @param arr
     */
    public static void bubllingSort(int [] arr){


        for(int i=1;i<arr.length;i++){
            boolean flag =true;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int x = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]= x;
                    flag=false; // 如果再当前的这躺还是无序的
                }
            }
            if(flag){
                break;
            }

        }
    }
    //====================================================

    /**
     * 选择排序
     * 再未排序的序列里面 找到最小的元素  放在起始位置
     * @param arr
     */
    private static  void selectionSort(int [] arr){

        for (int i=0;i<arr.length-1; i++){
            int temp = i;
            for(int j=i; j<arr.length-1;j++){
                if(arr[temp]>arr[j+1]){
                    temp=j+1;
                }
            }

            int x=arr[i];
            arr[i]=arr[temp];
            arr[temp]=x;
        }


    }

    //快速排序
    // 建立左右指针
    //{45,32,12,55,88,22,76,45,33};
    //右边替换  45为基准数
    //33,32,12,55,88,22,76,45,33
    //左边替换  33,32,12,55,88,22,76,45,55
    //右边替换  33,32,12,22,88,22,76,45,55
    //左边提花33,32,12,22,88,88,76,45,55
    //然后 l>r   替换88为45
    public static  void quickSort(int arr[],int l,int r){
        if(l<r){
            int i = l ;
            int j = r;
            int base = arr[l];
            while(i<j){
                //从右边往左边找 找到比他小的
                while(i<j&&arr[j]>=base){
                    j--;
                }
                //然后替换
                arr[i]=arr[j];
                //从左往右找 找到比他大的
                while(i<j&&arr[i]<=base){
                    i++;
                }
                arr[j]=arr[i];
            }
            arr[i]=base;
            quickSort(arr,l,i-1);
            quickSort(arr,i+1,r);
        }








    }







//====================================================
    /**
     * 堆排序 构建最大堆  然后 交换root 和  最后一个元素
     * 每次以最后一个来往前面冒泡比较  相当于层序比较
     * 问题 每次都要从最后一个地方进行建立堆  判断了非常多次 不好用 特别不好用
     */
    public static void preHeapSort(int[] arr){

        for(int i=arr.length-1;i>=0;i--){
            //先构建最大堆
            buildHeapMax(arr,i);
            //然后交换堆顶元素和最后一个元素
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
        }
    }
    //    0
    //  1       2
    // 3   4     5     6
    //7 8 9 10 11 12 13 14
    /**
     * 堆排序构建最大堆
     */
    public static void buildHeapMax(int arr[], int length){

        for(int i=length/2-1;i>=0;i--){
            int node = i;
            int left = 2*node +1;
            int right = 2*node +2;
            if(length<=arr.length&&arr[left]>arr[node]){
                int x = arr[node];
                arr[node]=arr[left];
                arr[left]=x;
                break;
            }
            if(length<=arr.length&&arr[right]>arr[node]){
                int x = arr[node];
                arr[node]=arr[right];
                arr[right]=x;
                break;
            }
        }
    }


        private void swap(int[] arr,int x,int y){
            int temp= arr[x];
            arr[x]=arr[y];
            arr[y]=temp;
        }


}
