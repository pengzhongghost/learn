
public class Test {
    public static void main(String[] args) {
        CircleLinkedList list = new CircleLinkedList();
        list.add(5);
        list.josefu(1,2,5);

    }
}


class CircleLinkedList {

    private Node head = null;

    public void add(int nums) {
        if (nums < 1) {
            return;
        }
        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.next = head;
                cur = head;
            } else {
                cur.next = node;
                node.next = head;
                cur = cur.next;
            }
        }
    }

    public void josefu(int startNum, int startCount, int count) {
        if (null == head) {
            System.out.println("链表为空");
            return;
        }
        Node helper = this.head;
        while (true) {
            if (helper.next == head) {
                break;
            }
            helper = helper.next;
        }
        for (int i = 0; i < startNum - 1; i++) {
            helper = helper.next;
            head = head.next;
        }
        while (true){
            if (head==helper){
                System.out.println(helper.id);
                break;
            }
            for (int i = 0; i < startCount - 1; i++) {
                head = head.next;
                helper = helper.next;
            }
            System.out.println(head.id);
            head = head.next;
            helper.next = head;
        }

    }

}

class Node {

    public int id;

    public Node next;

    public Node(int id) {
        this.id = id;
    }
}