/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/6/3 20:02
 *
 * @Classname 数组中第k个最大的元素
 * Description: 测试
 */

import java.util.Random;

/**
 *
 */
public class 数组中第k个最大的元素 {
    //快速排序的选择方法
    public int findKthLargest(int[] nums,int k){
       int len = nums.length;
       int left = 0;
       int right = len - 1;
       //第k大元素就是索引是len - k
       int target = len - k;
       while (true){
           int index = partition(nums,left,right);
           if (index == target)
               return nums[index];
           else if (index < target)
               left = index + 1;
           else
               right = index - 1;
       }
    }

    private int partition(int[] nums, int left, int right) {
       int pivot = nums[left];
       int j = left;
       for (int i = left + 1;i <= right; i++){
           if (nums[i] < pivot){
               j++;
               swap(nums,j,i);;
           }
       }
       swap(nums,j,left);
       return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //堆排序的选择方法
    public int findKthLargest_1(int[] nums,int k) {
        int heapSize = nums.length;
        //建立大根堆
        buildMaxHeap(nums,heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1 ; --i) {
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums,0,heapSize);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1,r = i * 2 + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]){
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]){
            largest = r;
        }
        if (largest != i){
            swap(nums,i,largest);
            maxHeapify(nums,largest,heapSize);
        }
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i>= 0;--i){
            maxHeapify(nums,i,heapSize);
        }
    }
}
