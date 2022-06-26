package leetcode题目.牛客华为;

import java.util.Scanner;

public class 矩阵乘法 {

    /**
     * https://www.nowcoder.com/practice/ebe941260f8c4210aa8c17e99cbc663b?tpId=37&tqId=21292&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[][] mat01 = new int[x][y];
        int[][] mat02 = new int[y][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                mat01[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < z; j++) {
                mat02[i][j] = sc.nextInt();
            }
        }
        int[][] result = mulity(mat01, mat02);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] mulity(int[][] mat01, int[][] mat02) {
        int x = mat01.length;
        int y = mat02.length;
        int z = mat02[0].length;
        int[][] result = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    result[i][j] += mat01[i][k] * mat02[k][j];
                }
            }
        }
        return result;
    }

}
