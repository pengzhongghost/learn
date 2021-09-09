package leetcode题目.贪心;

public class 含有所有字符串的最短字符串 {
    /**
     * 给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。
     * 如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
     * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static boolean check(int[] counts) {
        for (int ascill = 65; ascill <= 122; ascill++) {
            if (counts[ascill] > 0) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        int[] counts = new int[128];
        for (char achar : t.toCharArray()) {
            counts[achar]++;
        }
        String minString = "";
        char[] strs = s.toCharArray();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;
        while (right < strs.length) {
            counts[strs[right++]]--;
            while (check(counts)) {
                if (minLength > right - left) {
                    minLength = right - left;
                    minString = s.substring(left, right);
                }
                counts[strs[left++]]++;
            }
        }
        return minString;
    }

}
