package leetcode题目.递归回溯;

import java.util.LinkedList;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 字母组合迭代器 {

    /**
     * https://leetcode.cn/problems/iterator-for-combination/?envType=problem-list-v2&envId=backtracking
     */

    static class CombinationIterator {

        LinkedList<String> queue = new LinkedList();

        public CombinationIterator(String characters, int combinationLength) {
            dfs(characters, combinationLength, 0, "");
        }

        private void dfs(String characters, int combinationLength, int index, String temp) {
            if(temp.length() == combinationLength) {
                queue.offer(temp);
                return;
            }
            if(temp.length() > combinationLength) {
                return;
            }
            for(int i = index; i < characters.length(); i++) {
                dfs(characters, combinationLength, i + 1, temp + characters.charAt(i));
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }


}
