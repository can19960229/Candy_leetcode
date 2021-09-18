package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/27 15:06
 *
 * @Classname 寻找两个正序数组的中位数
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 寻找两个正序数组的中位数 {
    //简单暴力合并，合并后排序，之后按照奇偶数找出中位数
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        //合并数组
        int[] nums = new int[nums1.length + nums2.length];
        int len = nums.length;
        int k = 0;
        for(int i = 0;i < nums1.length;i++){
            nums[k++] = nums1[i];
        }
        for(int i = 0;i < nums2.length;i++){
            nums[k++] = nums2[i];
        }
        //对数组进行排序
        Arrays.sort(nums);
        //按照奇偶数找出中位数
        if(nums.length % 2 == 1){
            return (nums[len / 2]);
        }else{
            return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
        }
    }
    //归并的方法进行顺序合并
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int len = nums1.length + nums2.length;
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[len];
        if(m == 0){
            if(n % 2 == 0){
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }else{
                return nums2[n / 2];
            }
        }
        if(n == 0){
            if(m % 2 == 0){
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            }else{
                return nums1[m / 2];
            }
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while(count != m + n){
            if(i == m){
                while(j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == n){
                while(i != m){
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if(nums1[i] < nums2[j]){
                nums[count++] = nums1[i++];
            }else{
                nums[count++] = nums2[j++];
            }
        }

        if(count % 2 == 0){
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        }else{
            return nums[count / 2];
        }
    }


}
