import java.util.Arrays;

public class Test02 {

    public static void main(String[] args) {
        int[] stock = {4, 6, 8, 2, 3, 4};
        int low = 0;
        int high = stock.length - 1;
        while (low < high) {
            int pivot = (low + high) / 2;
            if (stock[pivot] > stock[high]) {
                low = pivot + 1;
            } else if (stock[pivot] < stock[high]) {
                high = pivot;
            } else {
                high--;
            }
        }
        System.out.println(low);
    }

//    static class Node {
//        public int val;
//        public Node prev;
//        public Node next;
//        public Node child;
//    }
//    //遍历结果
//    public static void preList(Node node) {
//        System.out.println(node.val);
//        if (node.left != null) {
//            preList(node.left);
//        }
//        if (node.right != null) {
//            preList(node.right);
//        }
//    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
