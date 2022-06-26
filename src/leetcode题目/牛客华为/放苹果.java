package leetcode题目.牛客华为;

import java.util.Scanner;

public class 放苹果 {

    /**
     * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
     * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
     * 数据范围：0≤m≤10 ，1≤n≤10 。
     *
     * 输入描述：
     * 输入两个int整数
     * 输出描述：
     * 输出结果，int型
     *
     * 示例1
     * 输入：
     * 7 3
     * 复制
     * 输出：
     * 8
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(count(m, n));
        }
    }

    // 递归功能：当前持有m个苹果，有n个盘子可供存放，返回摆放方案数
    private static int count(int m, int n) {
        // 递归出口：当苹果数m=0， 此时表示什么都不做，输出1种方案，再递归下去m<0，题目要求m>=0
        // 当盘子只有一个时，剩下的苹果m只能全部摆放这个盘子，递归返回1种方案，再递归下去n==0, 题目要求n>=1
        if(m == 0 || n == 1) {
            return 1;
        }
        // 当盘子数大于苹果数，一定有n-m个盘子空着，而且每个盘子都一样，因此count(m,n)==count(m,n-1)
        if(n > m) {
            return count(m, n-1);
        } else {
            // 当盘子数<=苹果数，有两种情况：
            // 1.至少有一个盘子可以不放，因此count(m, n-1)
            // 2.至少每个盘子都有一个苹果，摆放后苹果数为(m-n)，因此coutn(m-n, n)
            return count(m, n - 1) + count(m - n, n);
        }
    }

}
