/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/8 11:09
 *
 * @Classname 不用加减乘除做加法
 * Description: 测试
 */

/**
 *
 */
public class 不用加减乘除做加法 {
    public int add(int num1,int num2){
        int result;
        int ans;
        do{
            result = num1 ^ num2; //不带进位的加法
            ans = (num1 & num2) << 1;//进位
            num1 = result;
            num2 = ans;
        }while (ans != 0);//进位不为0则继续执行加法处理进位
        return result;
    }
}
