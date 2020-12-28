/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/28 21:01
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class 合并两个有序数组 {
    public void merge(int A[], int m, int B[], int n) {
        int[] A_copy = new int[m];
        System.arraycopy(A,0,A_copy,0,m);
        int first = 0;
        int second = 0;
        int count = 0;
        while ((first < m) && (second < n)){
            if (A_copy[first] > B[second]){
                A[count] = B[second];
                second++;
            }else {
                A[count] = A_copy[first++];
            }
            count++;

        }
        if (first < m){
            System.arraycopy(A_copy,first,A,first+ second,m + n - first -second);
        }
        if (second < n){
            System.arraycopy(B,second,A,first+ second,m + n - first - second);
        }



    }
}
