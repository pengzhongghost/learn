package leetcode题目.二叉树;

import java.util.HashMap;
import java.util.Map;

public class 前缀树 {
    public static void main(String[] args) {
        String str="apple";
        Trie02 trie02 = new Trie02();
        trie02.insert(str);
        System.out.println(trie02.startsWith("app"));
    }
}

class Trie02 {

    private TrieNode root;

    public Trie02() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);
            if (!cur.children.containsKey(index)) {
                cur.children.put(index, new TrieNode());
            }
            cur = cur.children.get(index);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);
            if (!cur.children.containsKey(index)) {
                return false;
            }
            cur = cur.children.get(index);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char index = prefix.charAt(i);
            if (!cur.children.containsKey(index)) {
                return false;
            }
            cur = cur.children.get(index);
        }
        return true;
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>(26);
        }
    }
}


/**
 * todo 前缀树
 */
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    class TrieNode {
        boolean isWord = false;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

}
