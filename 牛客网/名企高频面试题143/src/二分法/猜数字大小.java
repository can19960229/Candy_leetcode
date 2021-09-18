package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/14 10:10
 *
 * @Classname 猜数字大小
 * Description: 测试
 */

/**
 *
 */
public class 猜数字大小 {
    public int guessNumber(int n){
        int left = 1,right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if ((mid) <= 0){
                right = mid;//答案在区间[left,mid]
            }else {
                left = mid + 1;//答案在区间[mid+1,right]中
            }
        }
        //此时有left == right,区间缩为一个点，即为答案
        return left;
    }
}
