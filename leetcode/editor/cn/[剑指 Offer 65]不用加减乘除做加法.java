//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_65_1 {
    public int add(int a, int b) {
        while (b != 0){ //当进位为0时跳出
            int c = (a & b) << 1;  //计算进位c
            a ^= b; //计算无进位和n，赋值为a
            b = c; //将进位c赋值给b
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
