package leetcode题目.图.dfs;

import java.util.*;

public class 单词搜索II {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        List<String> list = findWords(board, words);
        System.out.println(list);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<String>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<String>(ans);
    }

    public static void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
        if (!now.children.containsKey(board[i][j])) {
            return;
        }
        char ch = board[i][j];
        now = now.children.get(ch);
        if (!"".equals(now.word)) {
            ans.add(now.word);
        }

        board[i][j] = '#';
        for (int[] dir : dirs) {
            int i2 = i + dir[0], j2 = j + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, now, i2, j2, ans);
            }
        }
        board[i][j] = ch;
    }
}

//todo 前缀树
class Trie {
    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.word = "";
        this.children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}