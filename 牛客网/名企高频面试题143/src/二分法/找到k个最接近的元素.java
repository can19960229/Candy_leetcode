package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/18 20:36
 *
 * @Classname 找到k个最接近的元素
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 找到k个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr,int k,int x){
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int removeNums = size - k;
        while (removeNums > 0){
            if (x - arr[left] <= arr[right] - x){
                right--;
            }else {
                left++;
            }
            removeNums--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left;i < left + k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}
