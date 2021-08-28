package 树.霍夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node node){
        System.out.println(node);
        if (null!=node.left){
            preOrder(node.left);
        }
        if (null!=node.right){
            preOrder(node.right);
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //循环构建霍夫曼树
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出权值最小的和次小的节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //构造一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除已经构建的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //把构建的二叉树的根节点放进nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }

}

//为了让node对象支持排序
class Node implements Comparable<Node> {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}