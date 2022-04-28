
public class Test02 {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/exchange-lcci/
     * 配对交换
     * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，
     * 位0与位1交换，位2与位3交换，以此类推）。
     * <p>
     * 示例1:
     * 输入：num = 2（或者0b10）
     * 输出 1 (或者 0b01)
     * <p>
     * 示例2:
     * 输入：num = 3
     * 输出：3
     */
    public static int exchangeBits(int num) {
        for (int i = 0; i < 30; i += 2) {
            int a = num >> i & 1;
            int b = num >> (i + 1) & 1;
            if (a != b) {
                num ^= 1 << i;
                num ^= 1 << (i + 1);
            }
        }
        return num;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

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
