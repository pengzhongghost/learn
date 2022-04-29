package leetcode题目.二分查找;

import java.util.ArrayList;
import java.util.List;

public class 数字流的秩 {
    /**
     * https://leetcode-cn.com/problems/rank-from-stream-lcci/
     * 数字流的秩
     * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
     * 请实现数据结构和算法来支持这些操作，也就是说：
     * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
     * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例:
     * 输入:
     * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
     * [[], [1], [0], [0]]
     * 输出:
     * [null,0,null,1]
     */
    public static void main(String[] args) {
        StreamRank rank = new StreamRank();
        System.out.println(rank.getRankOfNumber(1));
        rank.track(0);
        System.out.println(rank.getRankOfNumber(1));
    }

    static class StreamRank {

        List<Integer> list;

        public StreamRank() {
            list = new ArrayList<>();
        }

        public void track(int x) {
            list.add(getRankOfNumber(x), x);
        }

        public int getRankOfNumber(int x) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (list.get(mid) <= x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //todo 二分查找到最后一个大于x的数字的位置
            return left;
        }
    }
}
