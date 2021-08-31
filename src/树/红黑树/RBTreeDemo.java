package 树.红黑树;

public class RBTreeDemo {
    public static void main(String[] args) {
        RBTree<String, String> tree = new RBTree<>();
        tree.put("1", "张三");
        tree.put("2", "李四");
        tree.put("3", "王五");
        System.out.println(tree.get("1"));
        System.out.println(tree.get("2"));
        System.out.println(tree.get("3"));
    }

}

class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    //记录树中元素的个数
    private int N;
    //根节点
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //判断当前节点的父指向链接是否为红色
    public boolean isRed(Node node) {
        if (null == node) {
            return BLACK;
        }
        return node.color == RED;
    }

    //左旋
    public Node leftRotate(Node p) {
        //获取当前节点的右子节点
        Node r = p.right;
        //让当前节点的右子节点为他的右子节点的左子节点
        p.right = r.left;
        //让当前节点的右子节点的左子节点为当前节点
        r.left = p;
        //让当前节点的右子节点的color为当前节点的color
        r.color = p.color;
        //让当前节点的color为RED
        p.color = RED;
        return r;
    }

    //右旋
    public Node rightRotate(Node p) {
        Node l = p.left;
        p.left = l.right;
        l.right = p;
        l.color = p.color;
        p.color = RED;
        return l;
    }

    //颜色反转
    public void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    //在整个树上完成插入操作
    public void put(K key, V value) {
        root = put(root, key, value);
        //根节点的颜色总是黑色的
        root.color = BLACK;
    }

    //对指定节点进行添加
    private Node put(Node node, K key, V value) {
        if (node == null) {
            //数量+1
            N++;
            return new Node(null, null, RED, key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            //向左添加
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            //向右添加
            node.right = put(node.right, key, value);
        } else {
            //值的覆盖
            node.value = value;
        }
        //左旋 当前节点的左子节点是黑色，右子节点是红色
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        //右旋
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        //颜色反转
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    //获取值
    public V get(K key) {
        return get(root, key);
    }

    //指定node获取值
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    private class Node {
        private Node left;
        private Node right;
        private boolean color;
        private K key;
        private V value;

        public Node(Node left, Node right, boolean color, K key, V value) {
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }
    }

}