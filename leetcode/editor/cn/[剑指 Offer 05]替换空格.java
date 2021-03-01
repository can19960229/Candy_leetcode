//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 62 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_05 {
    public String replaceSpace_1(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    public String replaceSpace(String s) {
        int count = 0;//统计空格数量
        char[] chars = s.toCharArray();//把字符串转化为字符数组
        for (char c : chars) {
            if (c == ' '){
                count++;
            }
        }
        char[] newChars = Arrays.copyOf(chars,chars.length + count * 2);
        for (int oldIndex = chars.length - 1,
             newIndex = newChars.length - 1;
             oldIndex < newIndex; oldIndex--, newIndex--) {
            if (newChars[oldIndex] != ' '){
                newChars[newIndex] = newChars[oldIndex];
            }else{
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
                newChars[newIndex] = '%';
            }
        }
        return new String(newChars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
