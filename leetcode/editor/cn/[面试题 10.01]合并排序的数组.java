//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 
// 👍 100 👎 0


import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_10_01 {

    public void merge_1(int[] A, int m, int[] B, int n) {
        if (B == null || B.length < 1) {
            return;
        }

        int i = m - 1, j = n - 1, cnt = m + n - 1;
        while (j >= 0) {
            if (i < 0 || A[i] <= B[j]) {
                A[cnt--] = B[j--];
            } else {
                A[cnt--] = A[i--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
