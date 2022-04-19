package leetcode题目.java基础;

import java.util.HashMap;
import java.util.Map;

public class 外星语言是否排序 {
    /**
     * https://leetcode-cn.com/problems/lwyVBB/
     * 外星语言是否排序
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；
     * 否则，返回 false。
     */
    public static void main(String[] args) {
        String[] words = {"word", "world", "row"};
        System.out.println(isAlienSorted(words, "worldabcefghijkmnpqstuvxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word01 = words[i];
            String word02 = words[i + 1];
            for (int j = 0; j < Math.max(word01.length(), word02.length()); j++) {
                int m = j >= word01.length() ? -1 : map.get(word01.charAt(j));
                int n = j >= word02.length() ? -1 : map.get(word02.charAt(j));
                if (m > n) {
                    return false;
                }
                //todo n==m的情况跳过了
                if (n > m) break;
            }
        }
        return true;
    }
}
