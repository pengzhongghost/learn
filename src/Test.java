
public class Test {
    public static void main(String[] args) {
        SingleQueue<String> queue = new SingleQueue<>();
        queue.addQueue("刘备");
        queue.addQueue("关羽");
        queue.addQueue("张飞");
        queue.showQueue();
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        queue.showQueue();
        SingleQueue<Integer> queue02 = new SingleQueue<>();
        queue02.addQueue(1);
        queue02.addQueue(2);
        queue02.addQueue(3);
        queue02.showQueue();
    }
}

class SingleQueue<T> {

    private Node head = new Node(0, null, null);

    public void addQueue(T data) {
        Node temp = head;
        while (null != temp.next) {
            temp = temp.next;
        }
        int id = temp.id;
        id++;
        temp.next = new Node(id, data, null);
    }

    public Object getQueue() {
        while (null != head.next) {
            Object data = head.next.data;
            head = head.next;
            return data;
        }
        return null;
    }

    public void showQueue() {
        Node temp = head.next;
        if (null == temp) {
            System.out.println("队列为空");
            return;
        }
        while (null != temp) {
            System.out.printf(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

}

class Node<T> {

    public int id;

    public T data;

    public Node next;

    public Node(int id, T data, Node next) {
        this.id = id;
        this.data = data;
        this.next = next;
    }
}