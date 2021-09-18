package 十大排序;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/7/18 21:22
 *
 * @Classname 冒泡排序
 * Description: 测试
 */

/**
 *
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1,8,5,16,32,21};
        int temp;
        System.out.println("排序前的数组是：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("由小到大的排序为：");
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
