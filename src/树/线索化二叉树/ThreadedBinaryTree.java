package 树.线索化二叉树;

public class ThreadedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node02 = new HeroNode(3, "吴用");
        HeroNode node03 = new HeroNode(6, "卢俊义");
        HeroNode node04 = new HeroNode(8, "林冲");
        HeroNode node05 = new HeroNode(10, "关胜");
        HeroNode node06 = new HeroNode(14, "史进");
        tree.setRoot(root);
        root.left = node02;
        root.right = node03;
        node02.left = node04;
        node02.right = node05;
        node03.left = node06;
        tree.threadedNodes();
        HeroNode leftNode = node05.left;
        System.out.println(leftNode);
        System.out.println("========线索化遍历=========");
        tree.list();

    }
}

class BinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建指向当前节点的前驱节点的指针
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        threadedNodes(root);
    }

    //中序线索化方法
    public void threadedNodes(HeroNode node) {
        if (null == node) {
            return;
        }
        //线索化
        threadedNodes(node.left);
        //处理前驱节点
        if (null == node.left) {
            node.left = pre;
            node.leftType = 1;
        }
        //处理后继节点
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        //每处理一个节点，让当前节点是下一个节点的前驱节点
        pre = node;
        threadedNodes(node.right);

    }

    //遍历线索化二叉树
    public void list() {
        HeroNode node = root;
        while (null != node) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;
    //0-左子树，1-前驱节点
    public int leftType;
    //0-右子树，1-后继节点
    public int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}