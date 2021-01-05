/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/5 19:59
 * version 1.0
 * Description: 测试
 */


/**
 旋转矩阵
 */
public class Code_05_RotateMatrix {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    //	int tR 左上角点的行, int tC 左上角点的列, int dR 右下角点的行, int dC 右下角点的列（正方形）
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC; //如果有三个数，就两个出发点 0 1 2
        int tmp = 0;
        for (int i = 0; i != times; i++) {	//依次枚举
            tmp = m[tR][tC + i];	//原始出发点，把四个点的下标找到进行交换位置
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}
