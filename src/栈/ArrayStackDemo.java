package 栈;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.list();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.list();
    }

}

class ArrayStack {

    //数组模拟栈
    private int[] arr;

    //栈的大小
    private int maxSize;

    //top表示栈顶
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        arr[top] = value;
    }

    //出栈
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        int num = arr[top];
        top--;
        return num;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈是空的");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println();
    }

}
