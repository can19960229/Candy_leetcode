//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_17 {
    public int[] printNumbers_1(int n) {
        int end = (int) Math.pow(10,n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    /**
     * 大数打印法
     */
    int[] res;
    int nine = 0, count =0,start,n;
    char[] num,loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n){
        this.n = n;
        res = new int[(int) Math.pow(10,n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if (x == n){
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0"))
                res[count++] = Integer.parseInt(s);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
