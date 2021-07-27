package 队列.数组;

/**
 * 1.这种普通的数组使用一次就不能使用了，没有达到复用的效果
 * 2.将这种数组改成环形数组则可以复用
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.showQueue();
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        queue.showQueue();
    }

}

//使用数组模拟队列
class ArrayQueue {
    //表示数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //存放数据的数组，模拟队列
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头部的前一个位置
        front = -1;
        //直接指向队列尾部一个具体的数据(就是队列最后一个数据)
        rear = -1;
    }

    //判断队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列满了，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    //取数据
    public Integer getQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无数据");
            return null;
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无数据");
            return;
        }
        for (int i = front; i < arr.length; i++) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

}
