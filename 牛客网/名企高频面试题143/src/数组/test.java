package 数组;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/30 0:04
 *
 * @Classname test
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class test {
    public static void main(String[] args) {
    int[] aa = { 1, 3, 13, 9};
    int[] bb = { 5, 4, 7, 18};
    int[] cc = { 7, 5, 8, 11};
    List<int[]> arr = new ArrayList<>();
    arr.add(aa);
    arr.add(bb);
    arr.add(cc);
    System.out.println("结果是：");
    int[] aa0 = null;
    //两两将数组进行合并
    for (int i = 0; i < arr.size(); i++) {
        int[] aa1 = arr.get(i);
        int[] newInt = merge(aa0,aa1);
        aa0 = newInt;
    }
    Arrays.sort(aa0);//把这个去点就不有序了
    for (int i : aa0) {
        System.out.print(i + " ");
    }
}
    public static int[]  merge(int[] a,int[] b){
        if (a == null) return b;
        int[] c = new int[a.length+b.length];
        int i=0,j=0,k = 0;
        while (i<a.length&&j<b.length){
            if(a[i]>=b[j]){
                c[k++] = b[j++];
            }else {
                c[k++] = a[i++];
            }
        }
        while (j<b.length){
            c[k++] = b[j++];
        }
        while (i<a.length){
            c[k++] = a[i++];
        }
        return c;
    }

}
