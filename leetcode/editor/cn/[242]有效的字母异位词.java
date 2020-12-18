//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 266 👎 0


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_242 {

    //方法一：使用map集合，统计字符出现的频次
    /*

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        //map用来存储字符串中出现的字符
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        //遍历第一个字符串，把出现过的字符加入map中，并记录出现的次数
        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);

        }
        //遍历第二个字符串，如果出现和第一个字符串一样的字符，则把对应的出现的次数-1
        for (int i = 0; i < t.length(); i++) {

            //   当map中存在key时，输出对应的value
            //   当map中不存在key时，输出defaultValue:0
            Integer orDefault = map.getOrDefault(t.charAt(i), 0);
            //如果t字符串中出现了在s字符串中没有出现的字符，一开始就会把默认值设为0，如果为0直接返回
            if (orDefault == 0){
                return false;
            }
            if (orDefault > 0){
                orDefault--;
                map.put(t.charAt(i),orDefault);
            }
            //如果出现过在第一个字符串中的字符次数减为0了，则将键值对移除
            if (orDefault == 0){
                map.remove(t.charAt(i));
            }

        }
        return map.size() == 0;//如果map的长度为0 则表示两个字符串出现的字符次数一样，返回true


    }


     */

    //方法二：暴力，进行sort，再比较
    //长度相同的数组，先排序再使用Arrays.equals
    /*
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return  false;
        }
        //把字符串改成字符数组
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars,tChars);



    }


     */

    //方法三：使用数组，因为都是小写字母组成，定义一个临时数组tmpArr，分别遍历2个char数组
    //再因为长度相等，要么如果不同时，必然至少有一个字母次数 < 0,相同时应该都是 = 0
    //    字符串都是小写字母组成，使用临时数组存在每个字符出现次数。

    public  static boolean isAnagram(String s,String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] tmpArr = new int[26];
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            tmpArr[sChars[i] - 'a']++;
        }
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tmpArr[tChars[i] - 'a']--;
            //因为长度相等，那么不相同字母必然出现< 0
            if (tmpArr[tChars[i] - 'a'] < 0){
                return false;
            }
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
