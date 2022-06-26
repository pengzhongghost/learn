package leetcode题目.牛客华为;

import java.util.Scanner;

public class 完全数计算 {

    /**
     * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
     * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
     * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
     * 输入n，请输出n以内(含n)完全数的个数。
     *
     * 数据范围： \1≤n≤5×10的五次方
     *
     * 输入描述：
     * 输入一个数字n
     * 输出描述：
     * 输出不超过n的完全数的个数
     *
     * 示例1
     * 输入：
     * 1000
     * 复制
     * 输出：
     * 3
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        if(n>=6){
            for(int i=6;i<=n;i++){
                int sum=0;
                for(int j=1;j<=i/2;j++){
                    if(i%j==0){
                        sum+=j;
                    }
                }
                if(sum==i){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
