/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/5 19:58
 * version 1.0
 * Description: 测试
 */


/**
 顺时针打印矩阵
 */
public class Code_06_PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        //左上角的行小于等于右下角的行  左上角的列小于等于左下角的列
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);	//	每次打印完都把左上角的坐标往右下角移动，右下角的坐标往左上角移动
        }
    }


    //	int tR 左上角点的行, int tC 左上角点的列, int dR 右下角点的行, int dC 右下角点的列

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        //左上角的行和右下角的行在同一行 即 o————o横向结构
        if (tR == dR) {
            //把列进行相加
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        }
        // 左上角的列和右下角的列在同一列	纵向结构
		/*

		o
		|
		|
		o

		*/
        else if (tC == dC) {
            //把行进行相加
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {

            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}
