//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 717 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int first = 0;
        int second = 0;
        int count = 0;
        while ((first < m) && (second < n)){
            if (nums1_copy[first] > nums2[second]){
                nums1[count] = nums2[second];
                second++;
            }else {
                nums1[count] = nums1_copy[first++];
            }
            count++;

        }
        if (first < m){
            System.arraycopy(nums1_copy,first,nums1,first+ second,m + n - first -second);
        }
        if (second < n){
            System.arraycopy(nums2,second,nums1,first+ second,m + n - first - second);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
