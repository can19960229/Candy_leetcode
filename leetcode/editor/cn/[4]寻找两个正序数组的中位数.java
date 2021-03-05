//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 3764 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        //如果A数组长度+B数组长度total是奇数，则找total/2+1小的元素即为中位数
        if(total % 2 == 1) {
            int midIndex = total / 2 + 1;
            return getKthElement(nums1, nums2, midIndex);
        }
        //否则，找total/2，total/2+1这两个元素
        else {
            int midIndex_1 = total / 2;
            int midIndex_2 = total / 2 + 1;
            double a = getKthElement(nums1, nums2, midIndex_1);
            double b = getKthElement(nums1, nums2, midIndex_2);
            return (a + b) / 2.0D;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true) {
            //边界情况，当index1越界时，直接返回nums2的第k小元素
            if(index1 == len1) {
                return nums2[index2 + k - 1];
            }
            //边界情况，当index2越界时，直接返回nums1的第k小元素
            if(index2 == len2) {
                return nums1[index1 + k - 1];
            }
            //边界情况，k等于1时，返回nums1第一个元素和nums2第一个元素较小者
            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            //比较nums1[k/2-1]和nums2[k/2-1]
            //如果nums1的小，则忽略掉nums1[0] - nums1[k/2-1]这些元素
            //再更新 k，k 要减去忽略掉的那些元素，index1也要更新，待下轮使用
            if(pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
            //如果nums2的小，则忽略掉nums2[0] - nums2[k/2-1]这些元素
            //再更新 k，k 要减去忽略掉的那些元素，index2也要更新，待下轮使用
            else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
