package leetcode题目.排序;

import java.util.PriorityQueue;

public class 数据流的第K大数值 {
    /**
     * https://leetcode-cn.com/problems/jBjn9C/
     * 数据流的第K大数值
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     * 请实现 KthLargest 类：
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     * <p>
     * 示例：
     * 输入：
     * ["KthLargest", "add", "add", "add", "add", "add"]
     * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     * 输出：
     * [null, 4, 5, 5, 8, 8]
     * 解释：
     * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
     * kthLargest.add(3);   // return 4
     * kthLargest.add(5);   // return 5
     * kthLargest.add(10);  // return 5
     * kthLargest.add(9);   // return 8
     * kthLargest.add(4);   // return 8
     */
    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }

    static class KthLargest {

        PriorityQueue<Integer> queue;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
            System.out.println();
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }

    }
}
