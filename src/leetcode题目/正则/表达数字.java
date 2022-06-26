package leetcode题目.正则;

import java.util.Scanner;

public class 表达数字 {

    /**
     * 将一个字符串中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
     * 数据范围：字符串长度满足 1≤n≤100
     *
     * 输入描述：
     * 输入一个字符串
     * 输出描述：
     * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
     *
     * 示例1
     * 输入：
     * Jkdi234klowe90a3
     * 复制
     * 输出：
     * Jkdi*234*klowe*90*a*3*
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line.replaceAll("([0-9]+)","*$1*"));
    }

}
