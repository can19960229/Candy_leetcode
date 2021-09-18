package 二分法;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/20 20:47
 *
 * @Classname 寻找比目标字母大的最小字母
 * Description: 测试
 */

/**
 *
 */
public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(letters[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        //如果插入位置为最后一个位置letters.length,则返回letters[0]，则对left取模
        return letters[left % letters.length];
    }
}
