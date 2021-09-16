package leetcode题目.双指针;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    //双指针，r指针走到重复到则让l走到r
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            //r走到有重复的则让l++到r到位置,然后r再往后面走
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
