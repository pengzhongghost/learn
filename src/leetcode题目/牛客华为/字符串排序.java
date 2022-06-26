package leetcode题目.牛客华为;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 字符串排序 {

    /**
     * 编写一个程序，将输入字符串中的字符按如下规则排序。
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type 输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA 输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e 输出： Be?y
     * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
     * <p>
     * 输入描述：
     * 输入字符串
     * 输出描述：
     * 输出字符串
     * 示例1
     * 输入：
     * A Famous Saying: Much Ado About Nothing (2012/8).
     * 复制
     * 输出：
     * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<Character> chars = new ArrayList();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isLetter(c)) {
                chars.add(c);
            }
        }
        chars.sort(Comparator.comparingInt(Character::toLowerCase));
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                result.append(chars.get(j++));
            } else {
                result.append(c);
            }
        }
        System.out.println(result.toString());
    }

}
