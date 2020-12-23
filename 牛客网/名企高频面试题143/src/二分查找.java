/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/22 20:29
 * version 1.0
 * Description: 二分查找的元素返回的是位置的值
 */

/**
 *
 */
public class 二分查找 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int i = 0;
        int j = n - 1;
        int mid = i + (j - i)/ 2;
        while(i <= j){
            if(a[mid] < v){
                i = mid + 1;
                mid = (i + j)/2;
            }else if(mid > 0 && a[mid - 1] >= v){
                j = mid - 1;
                mid = (i + j)/2;
            }else{
                return mid + 1;
            }

        }
        return n + 1;
    }
}
