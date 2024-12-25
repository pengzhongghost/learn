package leetcode题目.递归回溯;

import java.util.Arrays;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 活字印刷 {

    /**
     * https://leetcode.cn/problems/letter-tile-possibilities/
     */

    public static void main(String[] args) {
        int result = numTilePossibilities("AAABBC");
        System.out.println(result);
    }

    static int count = 0;
    public static int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        dfs(chars, "", new boolean[tiles.length()]);
        return count;
    }

    private static void dfs(char[] tiles, String temp, boolean[] isVisited) {
        if (!"".equals(temp)) {
            System.out.println(temp);
            count++;
        }
        for (int i = 0; i < tiles.length; i++) {
            if (isVisited[i] || (i > 0 && !isVisited[i - 1] && tiles[i - 1] == tiles[i])) {
                continue;
            }
            isVisited[i] = true;
            dfs(tiles, temp + tiles[i], isVisited);
            isVisited[i] = false;
        }
    }


}
