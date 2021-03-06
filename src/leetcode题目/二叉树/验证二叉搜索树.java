package leetcode题目.二叉树;

public class 验证二叉搜索树 {
    /**
     * 验证二叉搜索树
     *给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 示例 1：
     * 输入：root = [2,1,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static boolean isValid = true;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(isValidBST(root));
    }

    public static long record= Long.MIN_VALUE;

    //中序遍历，让record从小变大
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //todo 先要return false,否则会继续往下走
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val > record) {
            record = root.val;
        } else {
            return false;
        }
        return isValidBST(root.right);
    }

    static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
