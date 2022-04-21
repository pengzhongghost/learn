package leetcode题目.前缀树;

public class 神奇的字典 {
    /**
     * https://leetcode-cn.com/problems/US1pGT/
     *神奇的字典
     * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
     * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
     * 使得所形成的新单词存在于已构建的神奇字典中。
     * 实现 MagicDictionary 类：MagicDictionary() 初始化对象
     * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，
     * dictionary 中的字符串互不相同bool search(String searchWord) 给定一个字符串 searchWord ，
     * 判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。
     * 如果可以，返回 true ；否则，返回 false 。
     *
     * 示例：
     * 输入
     * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
     * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
     * 输出
     * [null, null, false, true, false, false]
     * 解释
     * MagicDictionary magicDictionary = new MagicDictionary();
     * magicDictionary.buildDict(["hello", "leetcode"]);
     * magicDictionary.search("hello"); // 返回 False
     * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
     * magicDictionary.search("hell"); // 返回 False
     * magicDictionary.search("leetcoded"); // 返回 False
     */
    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        //dictionary.buildDict(new String[]{"hello", "leetcode"});
        //dictionary.buildDict(new String[]{"hello","hallo", "leetcode"});
        dictionary.buildDict(new String[]{"hello", "hallo", "leetcode", "judge"});
        System.out.println(dictionary.search("judge"));
    }

    static class MagicDictionary {

        MagicDictionary.Node root;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            root = new MagicDictionary.Node();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                insert(s);
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord, 0, 0, root);
        }

        public boolean dfs(String searchWord, int cnt, int index, MagicDictionary.Node node) {
            if (index == searchWord.length()) {
                return cnt == 1 && node.isWord;
            }
            if (cnt > 1) return false;
            boolean res = false;
            MagicDictionary.Node next = node.children[searchWord.charAt(index) - 'a'];
            if (next != null) {
                res = res || dfs(searchWord, cnt, index + 1, next);
            }
            for (MagicDictionary.Node child : node.children) {
                if (child != null && child != next) {
                    res = res || dfs(searchWord, cnt + 1, index + 1, child);
                }
            }
            return res;
        }

        public void insert(String word) {
            MagicDictionary.Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new MagicDictionary.Node();
                }
                temp = temp.children[index];
            }
            temp.isWord = true;
        }

        static class Node {
            boolean isWord;
            MagicDictionary.Node[] children;

            public Node() {
                this.children = new MagicDictionary.Node[26];
            }
        }

    }
}
