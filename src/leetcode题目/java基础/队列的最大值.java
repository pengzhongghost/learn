package leetcode题目.java基础;

import java.util.LinkedList;

public class 队列的最大值 {
    /**
     * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
     * 队列的最大值
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back
     * 和 pop_front 的均摊时间复杂度都是O(1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     * <p>
     * 示例 1：
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * <p>
     * 示例 2：
     * 输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     */
    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }

    static class MaxQueue {

        LinkedList<Integer> list;
        LinkedList<Integer> maxList;

        public MaxQueue() {
            list = new LinkedList<>();
            maxList = new LinkedList<>();
        }

        public int max_value() {
            if (maxList.isEmpty()) {
                return -1;
            }
            return maxList.peekFirst();
        }

        public void push_back(int value) {
            while (!maxList.isEmpty() && value > maxList.peekLast()) {
                maxList.pollLast();
            }
            maxList.offerLast(value);
            list.offerLast(value);
        }

        public int pop_front() {
            if (list.isEmpty()) return -1;
            Integer t = list.pollFirst();
            if (t.equals(maxList.peekFirst())) {
                maxList.pollFirst();
            }
            return t;
        }

    }
}
