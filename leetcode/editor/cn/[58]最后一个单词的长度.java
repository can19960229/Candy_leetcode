//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_58 {
    public int lengthOfLastWord(String s) {
        String y =s.trim();
        if (y.length() == 0) return 0;
        if (y.equals(" ")) return 0;
        StringBuilder sb = new StringBuilder();
        char[] c = y.toCharArray();
        int count = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] != ' '){
                sb.append(c[i]);
            }
            if (c[i] == ' '){
                break;
            }
        }
        String m = sb.toString();
        return m.length();
    }


    public int lengthOfLastWord2(String s){
        if (s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && count == 0) continue;//如果当前count为0，证明后面都是空格‘ ’
            if (c != ' '){
                count++;
            }else { //当count！= 0且不是空格，退出
                break;
            }
        }
        return  count;
    }

    public int lengthOfLastWord3(String s) {
        String y =s.trim();
        if (y.length() == 0) return 0;
        if (y.equals(" ")) return 0;
        char[] c = y.toCharArray();
        int count = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ' ' && count == 0) continue;     //如果当前count为0，证明后面都是空格‘ ’
            if (c[i] != ' '){
                count++;
            }else {
                break;
            }

        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
