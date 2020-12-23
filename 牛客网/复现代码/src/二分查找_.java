/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/23 9:11
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class 二分查找_ {
    public int upper_bound_ (int n, int v, int[] a) {
        int p = 0;
        int q = n - 1;
        int mid = p + (q - p) / 2;
        while (q >= p){
            if (a[mid] < v){
                q = mid - 1;
                mid = p + (q - p) / 2;
            }else if (mid > 0 && a[mid] >= v){
                p = mid + 1;
                mid = (p + q) / 2;
            }else {
                return mid + 1;
            }
        }

        return n + 1;

    }

}
