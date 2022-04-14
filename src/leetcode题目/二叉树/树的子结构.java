package leetcode题目.二叉树;

public class 树的子结构 {
    /**
     * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
     * 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * 例如:
     * 给定的树 A:
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * 给定的树 B：
     * <p>
     * 4
     * /
     * 1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * <p>
     * 示例 1：
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * <p>
     * 示例 2：
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     */
    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(3);
        node01.left = new TreeNode(4);
        node01.right = new TreeNode(5);
        node01.left.left = new TreeNode(1);
        node01.left.right = new TreeNode(2);
        TreeNode node02 = new TreeNode(4);
        node02.left = new TreeNode(1);
        System.out.println(isSubStructure(node01, node02));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private static boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
