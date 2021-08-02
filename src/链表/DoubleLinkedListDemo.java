package 链表;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
//        list.add(new Node(1, "潘凤"));
//        list.add(new Node(2, "邢道荣"));
//        list.add(new Node(3, "蒋干"));
//        list.list();
//        System.out.println();
//        Node node = new Node(2, "华雄");
//        list.update(node);
//        list.list();
//        System.out.println();
//        list.delete(new Node(2, ""));
//        list.list();
//        System.out.println();
        list.addByOrder(new Node(1, "潘凤"));
        list.addByOrder(new Node(3, "邢道荣"));
        list.addByOrder(new Node(2, "蒋干"));
        list.list();
    }

}

class DoubleLinkedList<T> {

    private Node head = new Node(0, null);

    public void add(Node node) {
        Node temp = this.head;
        while (null != temp.next) {
            temp = temp.next;
        }
        //形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    public void update(Node node) {
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (null == temp) {
                System.out.println("没有找到此节点：" + node);
                return;
            }
            if (node.id == temp.id) {
                temp.data = node.data;
                return;
            }
            temp = temp.next;
        }
    }

    public void delete(Node node) {
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp.next == null) {
                System.out.println("没有找到此节点：" + node);
                return;
            }
            if (node.id == temp.id) {
                if (null != temp.next) {
                    temp.next.pre = temp.pre;
                }
                temp.pre.next = temp.next;
                return;
            }
            temp = temp.next;
        }
    }

    public void list() {
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (null == temp) {
                return;
            }
            System.out.printf(temp + "\t");
            temp = temp.next;
        }

    }

    //有序的添加
    public void addByOrder(Node node) {
        Node temp = head;
        while (true) {
            if (null == temp.next) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            }
            temp = temp.next;
        }
        if (null != temp.next) {
            temp.next.pre = node;
        }
        node.next = temp.next;
        temp.next = node;
        node.pre = temp;
    }


}

class Node<T> {

    public int id;

    public T data;

    //指向前一个节点
    public Node pre;

    //指向下一个节点
    public Node next;

    public Node(int id, T data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}