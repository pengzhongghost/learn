package leetcode题目.java基础;

import java.util.ArrayList;
import java.util.List;

public class 复原IP {
    /**
     * https://leetcode-cn.com/problems/0on3uN/
     * 复原IP
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
     * 和 "192.168@1.1" 是 无效 IP 地址。
     * <p>
     * 示例 1：
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        for (int i = 1; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    if (check(s, i, j, k)) {
                        StringBuilder res = new StringBuilder();
                        res.append(s.substring(0, i)).append(".");
                        res.append(s.substring(i, j)).append(".");
                        res.append(s.substring(j, k)).append(".");
                        res.append(s.substring(k));
                        result.add(res.toString());
                    }
                }
            }
        }
        return result;
    }

    public static boolean check(String s, int i, int j, int k) {
        String substring = s.substring(0, i);
        if (substring.length() > 1 && substring.charAt(0) == '0' || Integer.parseInt(substring) > 255) {
            return false;
        }
        substring = s.substring(i, j);
        if (substring.length() > 1 && substring.charAt(0) == '0' || Integer.parseInt(substring) > 255) {
            return false;
        }
        substring = s.substring(j, k);
        if (substring.length() > 1 && substring.charAt(0) == '0' || Integer.parseInt(substring) > 255) {
            return false;
        }
        substring = s.substring(k);
        if (substring.length() > 1 && substring.charAt(0) == '0' || Integer.parseInt(substring) > 255) {
            return false;
        }
        return true;
    }
}
