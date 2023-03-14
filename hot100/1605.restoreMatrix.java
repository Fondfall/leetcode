/**
 * 1605.
 * 给你两个非负整数数组rowSum 和colSum，其中rowSum[i]是二维矩阵中第 i行元素的和， colSum[j]是第 j列元素的和。
 * 换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * 请找到大小为rowSum.length x colSum.length的任意 非负整数矩阵，且该矩阵满足rowSum 和colSum的要求。
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个可行矩阵
 */

import java.util.Arrays;

/**
 * 思路：构造一个矩阵，从左上到右下，它的每一个元素是行和与列和的最小值，同时行和和列和减去此值
 * 遍历结束即能构造出一个满足条件的矩阵
 * (它只是一个特殊解)
 */

class Solution {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int min = 0;
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                min = Math.min(rowSum[i], colSum[j]);
                if (min != 0) {
                    arr[i][j] = min;
                    rowSum[i] -= min;
                    colSum[j] -= min;

                    if(Math.max(rowSum[i], colSum[j]) ==0){
                        break;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] r = new int[]{5,7,10};
        int[] c = new int[]{8,6,8};
        int[] r1 = new int[]{5,7,10};
        int[] c1 = new int[]{8,6,8};
        int i=0;
        int[][] a= restoreMatrix(r1,c1);
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");

            }
            System.out.print("\t" + r[i++]);
            System.out.println();
        }
        System.out.println();
        for (int i1 : c) {
            System.out.print(i1 + " ");
        }
    }


}
