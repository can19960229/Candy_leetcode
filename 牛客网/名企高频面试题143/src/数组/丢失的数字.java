package 数组;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/29 16:07
 *
 * @Classname 丢失的数字
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 丢失的数字 {
    public int missingNumber(int[] nums){
        Arrays.sort(nums);
        //判断n是否出现在末位
        if (nums[nums.length-1] != nums.length){
            return nums.length;
        }
        //判断0是否出现在首位
        else if (nums[0] != 0){
            return 0;
        }
        for(int i = 1;i < nums.length;i++){
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum){
                return expectedNum;
            }
        }
        return -1;
    }
    /*
    明显，数组只缺少一个数字，即可利用下标巧妙求解。
    一共进行两次递归：
    1，第一次递归，让数组元素数值与其下标数值（或数组长度）相等；
    2，最大值特殊处理，用变量max标记，若未出现，则直接返回数组长度，否则进行二次递归；
    3，第二次递归，若数组值为最大值，则表示原数组中没有与该下标相等的值，返回对应下标即可。

     */

    public int missingNumber(int[] num,int numsSize){
        int i = 0,temp,max = 0;//用max变量标记最大值
        for (;i < numsSize;i++){
            if (num[i] != i){//利用下标值，递归让下标志与数组值相等
                if (num[i] == numsSize){
                    max = 1;
                    continue;
                }
                //数组值不是最大值
                temp = num[i];
                num[i--] = num[temp];
                num[temp] = temp;
            }
        }
        if (max == 0)
            return numsSize;//如果最大值没有出现在数组中，则返回最大值
        for (i = 0;i <= numsSize;i++){
            if (num[i] == numsSize){
                return i;
            }
        }
        return 0;
    }
    /*
     二分查找
     */
    public int missingNumber1(int[] nums) {
        //二分查找
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        //这里相等是因为left和right可能都指向缺口的前一个，所以需要再循环一次，让left加1，指向正确的缺口
        while (left <= right) {
            //取中间值
            int mid = left + (right - left) / 2;
            //如果内容和下标一致，说明在右边
            if (nums[mid] == mid)   left = mid + 1;
            else    right = mid - 1;
        }
        return left;
    }


}
