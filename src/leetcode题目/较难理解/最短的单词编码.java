package leetcode题目.较难理解;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 最短的单词编码 {
    /**
     * https://leetcode-cn.com/problems/iSwD2y/
     * 最短的单词编码
     * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
     * words.length == indices.length
     * 助记字符串 s 以 '#' 字符结尾
     * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
     * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
     *
     * 示例 1：
     * 输入：words = ["time", "me", "bell"]
     * 输出：10
     * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
     * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
     * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
     * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
     *
     * 示例 2：
     * 输入：words = ["t"]
     * 输出：2
     * 解释：一组有效编码为 s = "t#" 和 indices = [0] 。
     */
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int res = 0;
        for (String s : set) {
            res += s.length() + 1;
        }
        return res;
    }

}
