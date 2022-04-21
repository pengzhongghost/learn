package leetcode题目.前缀树;

import java.util.Arrays;
import java.util.List;

public class 替换单词 {
    /**
     * https://leetcode-cn.com/problems/UhWRSj/
     * 替换单词
     * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
     * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * 需要输出替换之后的句子。
     * <p>
     * 示例 1：
     * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     */
    public static void main(String[] args) {
        String[] sts = {"catt", "cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(Arrays.asList(sts), sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String rootWord = trie.getRootWord(words[i]);
            if (rootWord != null) {
                words[i] = rootWord;
            }
        }
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    static class Trie {


        Trie.Node root;

        public Trie() {
            root = new Trie.Node();
        }

        public void insert(String word) {
            Trie.Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new Trie.Node();
                }
                temp = temp.children[index];
            }
            temp.isWord = true;
        }

        public String getRootWord(String word) {
            Trie.Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (temp.isWord) {
                    return word.substring(0, i);
                }
                if (temp.children[index] == null) {
                    return null;
                }
                temp = temp.children[index];
            }
            return null;
        }

        static class Node {
            boolean isWord;
            Trie.Node[] children;

            public Node() {
                this.children = new Trie.Node[26];
            }
        }

    }
}
