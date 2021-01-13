/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/12 14:49
 * version 1.0
 * Description: 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 *
 * 输入
 *
 * "1AB2345CD","12345EF"
 *
 * 返回值
 *
 * "2345"
 */

import org.junit.Test;

import java.util.Scanner;

/**
 *
 */
public class SubString {
    @Test
    public void test1() {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            SubString test = new SubString();
            String r = test.LCS(str1,str2);
            System.out.println(r);
        }
        sc.close();
    }

    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        if(str1.length() == 0 || str2.length() == 0){
            return "-1";
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int endIndex = -1;
        int max = 0;

        int [][] arr = new int[s1.length][s2.length];
        for(int i= 0 ;i<s1.length;i++){
            for(int j = 0;j<s2.length;j++){
                if(i == 0 || j ==0){
                    arr[i][j] = s1[i] == s2[j] ? 1 : 0;
                }else{
                    if(s1[i] == s2[j]){
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if(arr[i][j] > max){
                    max = arr[i][j];
                    endIndex = i;
                }
            }
        }
        return endIndex == -1 ? "-1" : str1.substring(endIndex-max + 1,endIndex + 1);
    }
}
