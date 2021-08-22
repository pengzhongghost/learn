package 树;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node02 = new HeroNode(2, "吴用");
        HeroNode node03 = new HeroNode(3, "卢俊义");
        HeroNode node04 = new HeroNode(4, "林冲");
        HeroNode node05 = new HeroNode(5, "关胜");
        tree.setRoot(root);
        root.left = node02;
        root.right = node03;
        node03.right = node04;
        node03.left = node05;
        //遍历二叉式 前序 中序 后序
        System.out.println("前序");
        tree.preOrder();
        System.out.println("中序");
        tree.infixOrder();
        System.out.println("后序");
        tree.postOrder();

    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (null != this.root) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (null != this.root) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (null != this.root) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

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

    //编写前序遍历都方法
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归左子树
        if (null != this.left) {
            this.left.preOrder();
        }
        //递归右子树
        if (null != this.right) {
            this.right.preOrder();
        }
    }

    //编写中序遍历方法
    public void infixOrder() {
        //递归向左子树遍历
        if (null != this.left) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if (null != this.right) {
            this.right.infixOrder();
        }
    }

    //后续遍历方法
    public void postOrder() {
        //向左子树后续遍历
        if (null != this.left) {
            this.left.postOrder();
        }
        //向右子树后续遍历
        if (null != this.right) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

}