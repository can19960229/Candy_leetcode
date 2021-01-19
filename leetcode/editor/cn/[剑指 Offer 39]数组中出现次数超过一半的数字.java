//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 102 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_39_1 {
    /**
     * 用一般的排序也可以完成这道题目，但是如果那样完成的话就可能太简单了。
     * 用preValue记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；
     * 如果不同count--，减到0的时候就要更换新的preValue值了，因为如果存在超过数组长度一半的值，那么最后preValue一定会是该值。
     */
    public int majorityElement_1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int preValue = nums[0];//用来记录上一次的记录
        int count = 1;//preValue出现的次数（相减之后）
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == preValue){
                count++;
            }else {
                count--;
                if (count == 0){
                    preValue = nums[i];
                    count = 1;
                }
            }
        }
        int num = 0;//需要判断是否真的是大于一半的数，
        // 因为我们的上一次遍历只是保证如果存在超过一半的数就是preValue，但不代表preValue一定会超过一半
        for(int i = 0;i <nums.length;i++){
            if (nums[i] == preValue){
                num++;
            }
        }
        return (num > nums.length/2)?preValue:0;
    }

    /**
     * 使用一个 map 来记录各个数字出现的次数，最后取出现次数最多的作为解
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Integer key: map.keySet()){
            if(map.get(key) > len /2){
                return key;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
