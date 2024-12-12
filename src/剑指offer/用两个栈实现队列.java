package 剑指offer;

import java.util.LinkedList;

public class 用两个栈实现队列 {
    LinkedList<Integer> stack01;
    LinkedList<Integer> stack02;

    public 用两个栈实现队列() {
        stack01 = new LinkedList();
        stack02 = new LinkedList();
    }

    public void appendTail(int value) {
        stack01.push(value);
    }

    public int deleteHead() {
        if(stack02.isEmpty()) {
            if(stack01.isEmpty()) {
                return -1;
            }
            while(!stack01.isEmpty()) {
                stack02.push(stack01.pop());
            }
        }
        return stack02.pop();
    }

}
