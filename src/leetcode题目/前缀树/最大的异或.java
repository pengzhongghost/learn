package leetcode题目.前缀树;

public class 最大的异或 {
    /**
     * https://leetcode-cn.com/problems/ms70jA/
     * 最大的异或
     * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     * <p>
     * 示例 1：
     * 输入：nums = [3,10,5,25,2,8]
     * 输出：28
     * 解释：最大运算结果是 5 XOR 25 = 28.
     */
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, num ^ trie.search(num));
        }
        return res;
    }

    static class Trie {

        Trie.Node root;

        public Trie() {
            root = new Trie.Node();
        }

        public void insert(int num) {
            Trie.Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int index = (num >> i) & 1;
                if (temp.children[index] == null) {
                    temp.children[index] = new Trie.Node();
                }
                temp = temp.children[index];
            }
            temp.isEnd = true;
            temp.num = num;
        }

        public int search(int num) {
            Trie.Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int index = (num >> i) & 1;
                //todo 找和我这个数的bit位不同异或才最大
                int f = index == 0 ? 1 : 0;
                if (temp.children[f] == null) {
                    temp = temp.children[index];
                } else {
                    temp = temp.children[f];
                }
            }
            return temp.num;
        }

        static class Node {
            int num;
            boolean isEnd;
            Trie.Node[] children;

            public Node() {
                this.children = new Trie.Node[2];
            }
        }

    }
}
