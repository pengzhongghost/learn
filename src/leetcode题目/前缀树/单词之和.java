package leetcode题目.前缀树;

import java.util.HashMap;
import java.util.Map;

public class 单词之和 {

    /**
     * https://leetcode-cn.com/problems/z1R5dt/
     * 单词之和
     * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
     * MapSum() 初始化 MapSum 对象
     * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
     * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
     *
     * 示例：
     * 输入：
     * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
     * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
     * 输出：
     * [null, null, 3, null, 5]
     * 解释：
     * MapSum mapSum = new MapSum();
     * mapSum.insert("apple", 3);
     * mapSum.sum("ap");           // return 3 (apple = 3)
     * mapSum.insert("app", 2);
     * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
     */
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("ap"));
    }

    static class MapSum {

        MapSum.TrieNode root;
        Map<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new MapSum.TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int value = val - map.getOrDefault(key, 0);
            MapSum.TrieNode cur = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new MapSum.TrieNode();
                }
                cur = cur.children[index];
                cur.val += value;
            }
            map.put(key, val);
        }

        public int sum(String prefix) {
            MapSum.TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    return 0;
                }
                cur = cur.children[index];
            }
            return cur.val;
        }

        class TrieNode {
            int val;
            MapSum.TrieNode[] children;

            public TrieNode() {
                children = new MapSum.TrieNode[26];
            }
        }

    }
    
}
