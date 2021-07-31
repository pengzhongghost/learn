package 队列.数组;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.showQueue();
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        queue.showQueue();
    }
}

//环形数组，环形队列
class CircleArrayQueue {
    //表示数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //存放数据的数组，模拟队列
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头部的一个具体的数据
        front = 0;
        //直接指向队列尾部一个具体的数据(就是队列最后一个数据)
        rear = 0;
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = num;
        //将rear后移，这里考虑取余, 是为了保证rear<maxSize
        rear = (rear + 1) % maxSize;
    }

    //取数据
    public Integer getQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无数据");
            return null;
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无数据");
            return;
        }
        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%s]=%s\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    //求出当前队列的有效数据
    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示头元素
    public Integer headQueue(){
        if (isEmpty()){
            return null;
        }
        return arr[front];
    }
}

class CircleQueueV2 {

    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public CircleQueueV2(int maxSize) {
        this.maxSize = maxSize + 1;
        this.front = 0;
        this.rear = 0;
        arr = new int[this.maxSize];
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public Integer getQueue() {
        if (isEmpty()) {
            return null;
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("队列中无数据");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf(arr[i % maxSize] + "\t");
        }
        System.out.println();
    }

}