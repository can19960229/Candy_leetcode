//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 85 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_58_11 {


    /**
     * 代码冗余
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_1(String s, int n) {
        char[] chars = s.toCharArray();
        Character[] res = new Character[chars.length];
//        System.out.println(res.length);
        int j =  chars.length - n;
        for (int i = 0; i < chars.length; i++) {
            if (i >= n){
                res[i - n] = chars[i];
//                System.out.println(Arrays.toString(res));
            }else {
                res[j] = chars[i];
//                System.out.println(Arrays.toString(res));
                if (j < chars.length - 1){
                    j++;
                }
//                System.out.println(j);
            }
        }
        StringBuilder str = new StringBuilder();
        for (Character re : res) {
            str.append(re);
        }
        return str.toString();
    }

    /**
     * 直接利用字符串切片
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_2(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    /**
     * 要求不能使用切片函数
     * 列表遍历拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_3(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n;i < s.length();i++){
            res.append(s.charAt(i));
        }
        for (int i = 0;i < n;i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    /**
     * 要求不能使用切片函数
     * 列表遍历拼接 + 求余运算 ————可以简化代码
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_4(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
    /**
     * 以下两种方法效率低下，因为字符串一旦生成，其内容是不能改变的
     */

    /**
     * 要求只能使用String
     * 字符串遍历拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < s.length(); i++) {
            res += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            res += s.charAt(i);
        }
        return res;
    }

    /**
     * 要求只能使用String
     * 列表遍历拼接 + 求余运算 ————可以简化代码
     */
    public String reverseLeftWords_6(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
