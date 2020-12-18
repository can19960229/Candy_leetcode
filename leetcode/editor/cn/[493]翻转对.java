//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 241 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution_493 {
    public int ret;

    public int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums,0,nums.length-1);
        return ret;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (right <= left){
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(nums, left, middle);
        mergeSort(nums,middle+1,right);

        int count = 0;
        for (int l = left,r = middle + 1;l <= middle;){
            if (r > right || (long)nums[l] <= 2*(long)nums[r]){
                l++;
                ret += count;
            }else {
                r++;
                count++;
            }
        }
        Arrays.sort(nums,left,right+1);
    }
}

 /*

class Solution{
    public int reversePairs(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums,0,nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {

        if (l >= r) return 0;
        int mid = l + (r - l)/2;
        int count = mergeSort(nums,l,mid) + mergeSort(nums,mid+1,r);
        int[] cache = new int[r - l + 1];
        int i = l,t = 1,c = 0;
        for (int j = mid + 1;j <= r;j++,c++){
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while(t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache,0,nums,l,r - l + 1);
        return count;
    }
}

 */
//leetcode submit region end(Prohibit modification and deletion)
