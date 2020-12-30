//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法 
// 👍 110 👎 0


import java.util.Arrays;

/**
 * 解题思路
 * 插入排序法，在原数组上进行操作。
 * 首先对石头数组进行排序，定义变量len表示剩余石头数，初始为stones.length - 1。
 * 取剩余石头中最大的两个，即stones[len]和stones[len - 1]。
 * 这时有两种情况：
 * 1.当这两块石头一样重时，粉碎后为0 ，无需进行插入操作，石头数减少2，将len减少2即可。
 * 2.当有剩余石头时，假设剩余一块重量为r的石头，总石头数减少1，将len减少1，同时将重量r的石头按序插入数组。
 * 循环上述步骤直到len<=1，根据len的值是否为0返回0或者stones[len]。
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length - 1;
        while (len >= 1){
            int x = stones[len - 1];
            int y = stones[len];
            int r = x - y >= 0? x - y:y - x;
            if (r > 0){
                len = len - 1;
                int i = len - 1;
                //把粉碎后的石头插入到数组，插入后数组还是有序的
                while (i >= 0 && stones[i] > r){
                    stones[i + 1] = stones[i];
                    i--;
                }
                stones[i+1] = r;
            }else {
                len = len - 2;
            }
        }
        return len > -1 ? stones[len] : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
