package leetcode题目.java基础;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 堆盘子 {
    /**
     * https://leetcode-cn.com/problems/stack-of-plates-lcci/
     * 堆盘子
     * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，
     * 我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，
     * 并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()
     * 应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
     * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
     * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
     * <p>
     * 示例1:
     * 输入：
     * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
     * [[1], [1], [2], [1], [], []]
     * 输出：
     * [null, null, null, 2, 1, -1]
     */
    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates(1);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.popAt(0));
//        System.out.println(stack.popAt(0));
//        System.out.println(stack.popAt(0));
        stack.push(1);
        stack.push(2);
        System.out.println(stack.popAt(1));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class StackOfPlates {

        List<Stack<Integer>> list;
        int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
            this.list = new ArrayList<>();
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }
            if (list.isEmpty() || list.get(list.size() - 1).size() == cap) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                list.add(stack);
                return;
            }
            list.get(list.size() - 1).push(val);
        }

        public int pop() {
            return popAt(list.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= list.size()) {
                return -1;
            }
            Stack<Integer> stack = list.get(index);
            if (stack.isEmpty()) {
                return -1;
            }
            Integer pop = stack.pop();
            if (stack.isEmpty()) {
                list.remove(index);
            }
            return pop;
        }
    }
}
