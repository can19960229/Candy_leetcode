/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/15 20:01
 *
 * @Classname 排序
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 排序 {


    /**
     * 快速排序
     * @param arr
     * @return
     */
    public int[] MySort (int[] arr) {
        // write code here
        if (arr.length == 0)return new int[0];
        quickSort(arr,0,arr.length - 1);
        return arr;

    }

    private void quickSort(int[] arr, int low, int high) {
        if (high < low)return;
        int v = arr[low];
        int i = low;
        int j = high;
        while (i < j){
            while (arr[i] < v && i < j){
                i ++;
            }
            while (arr[j] > v && i < j){
                j--;
            }
            exch(arr,i,j);
        }
        exch(arr,i,low);

        quickSort(arr,low,i - 1);

        quickSort(arr,i + 1,high);



    }
    private void exch(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
