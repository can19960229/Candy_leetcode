//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 310 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_56_1 {
    public int[] singleNumbers_1(int[] nums) {
        Map<Integer,Integer> dic = new HashMap<Integer, Integer>();
        for (int num : nums) {
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if (dic.get(nums[i]) == 1){
                res[j++] = nums[i];
            }
        }
        return res;
    }

    public int[] singleNumbers_2(int[] nums) {
        int x = 0,y = 0, n = 0,m = 1;
        for (int num : nums) { // 遍历nums执行异或运算
            n ^= num;
        }
        while ((n & m) == 0){ // m 循环左移一位，直到 z & m ！= 0
            m <<= 1;
        }
        for (int num : nums) {
            if ((num & m) != 0) // 若 num & m != 0 , 划分至子数组 1 ，执行遍历异或
                x ^= num;
            else
                y ^= num;  // 若 num & m == 0 , 划分至子数组 2 ，执行遍历异或
        }
        return new int[]{x,y};  // 遍历异或完毕，返回只出现一次的数字 x 和 y
    }



    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            //存在则删除
            if(set.contains(num)){
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        int[] arr = new int[2];
        int i = 0;
        for(int y : set){
            arr[i++] = y;
        }
        return arr;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
