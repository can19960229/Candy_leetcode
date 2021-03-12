//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 388 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_718 {
    //滑动窗口法
    /*
    public int findLength(int[] A, int[] B) {



        return A.length < B.length ? findMax(A,B) : findMax(B,A);
    }

    private int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length,bn = B.length;
        //进入时候的处理，从1到an长度
        for (int len = 1;len <= an;len++){
            max = Math.max(max,maxLen(A,0,B,bn - len,len));
        }
        //中间过程的处理，长度保持在an
        for(int j = bn - an; j>= 0;j--){
            max = Math.max(max,maxLen(A,0,B,j,an));
        }
        //出去时的处理，长度从an到0，相当于A左移
        for(int i = 1;i < an; i++){
            max = Math.max(max,maxLen(A,i,B,0,an - i));
        }
        return max;
    }


    private int maxLen(int[] a, int i, int[] b, int j, int len) {
        int count = 0,max = 0;
        for (int k = 0; k < len; k++) {
            if (a[i+k] == b[j+k]){
                count++;
            }else if(count > 0){
                max = Math.max(max,count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max,count) : max;

    }

     */


    //动态规划
    public int findLength(int[] A, int[] B) {
        int n = A.length,m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for(int i = n - 1;i >= 0;i--){
            for(int j = m - 1;j>= 0;j--){
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
