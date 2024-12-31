package 动态规划;

import java.util.HashMap;
import java.util.Map;

public class 字符串贴纸组成目标字符串 {

    /**
     * 给定一个字符串str，给定一个字符串类型的数组arr。
     * arr里的每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来。
     * 返回需要至少多少张贴纸可以完成这个任务，
     * 例子:str= "babac", arr = {"ba","c","abcd"}
     * 至少需要两张贴纸"ba"和"abcd"，因为使用这两张贴纸，把每一个字符单独剪开，
     * 含有2个a、2个b、1个c。是可以拼出str的。所以返回2。
     */
    public static void main(String[] args) {
        String[] stickers= {"ba","c","abcd"};
        int result = minStickers1(stickers, "babac");
        System.out.println(result);
    }

    public static int minStickers1(String[] stickers, String target) {
        int[][] map = new int[stickers.length][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                map[i][c - 'a']++;
            }
        }
        dp.put("", 0);
        return process1(dp, map, target);
    }

    private static int process1(Map<String, Integer> dp, int[][] map, String target) {
        //当为""了，就返回0了
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int ans = Integer.MAX_VALUE;
        int[] tmap = new int[26];
        for (char c : target.toCharArray()) {
            tmap[c - 'a']++;
        }
        for (int i = 0; i < map.length; i++) {
            //不存在这个字符就跳过
            if (0 == map[i][target.charAt(0) - 'a']) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            //减去某个贴纸的字符还剩下什么字符
            for (int j = 0; j < 26; j++) {
                if (tmap[j] > 0) {
                    for (int k = 0; k < Math.max(0, tmap[j] - map[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            int tmp = process1(dp, map, sb.toString());
            if (-1 != tmp) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }


}
