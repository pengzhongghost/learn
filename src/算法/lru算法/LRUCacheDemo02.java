package 算法.lru算法;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo02 {

    //node节点
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    //双向链表
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //删除节点
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        //获取最后一个节点
        public Node getLast() {
            return tail.prev;
        }

    }

    private int cacheSize;

    Map<Integer, Node<Integer, Integer>> map;

    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo02(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            //size满了
            if (map.size() == cacheSize) {
                Node last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            //新增数据
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.addHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo02 demo02 = new LRUCacheDemo02(3);
        demo02.put(1, 1);
        demo02.put(2, 2);
        demo02.put(3, 3);
        System.out.println(demo02.map);
        demo02.put(4, 4);
        System.out.println(demo02.map);
        System.out.println(demo02.get(2));
        Node<Integer, Integer> head = demo02.doubleLinkedList.head;
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }


}
