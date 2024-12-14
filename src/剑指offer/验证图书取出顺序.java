package 剑指offer;

import java.util.Stack;

public class 验证图书取出顺序 {

    /**
     * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/description/
     */
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack();
        int t= 0;
        for(int num : putIn) {
            stack.push(num);
            while(!stack.isEmpty() &&stack.peek() == takeOut[t]) {
                stack.pop();
                t++;
            }
        }
        return stack.isEmpty();
    }

}
