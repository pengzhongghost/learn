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
        System.out.println("=========查找========");
        System.out.println(tree.preSeatrch(5));
        System.out.println(tree.indixSearch(5));
        System.out.println(tree.postSearch(5));
        System.out.println("=========删除========");
        tree.delNode(1);
        tree.preOrder();
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

    //前序查找
    public HeroNode preSeatrch(int no) {
        if (null != root) {
            return this.root.preSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode indixSearch(int no) {
        if (null != root) {
            return this.root.infixSearch(no);
        } else {
            return null;
        }
    }

    //后续查找
    public HeroNode postSearch(int no) {
        if (null != root) {
            return this.root.postSearch(no);
        }
        return null;
    }

    //删除节点
    public void delNode(int no) {
        if (null != root) {
            //删除root节点
            if (root.no == no) {
                root = null;
                return;
            }
            this.root.delNode(no);
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

    //前序查找
    public HeroNode preSearch(int no) {
        if (this.no == no) {
            return this;
        }
        //此处是为了防止left中没找到直接返回空值
        HeroNode result = null;
        if (null != this.left) {
            result = this.left.preSearch(no);
        }
        if (null != result) {
            return result;
        }
        if (null != this.right) {
            result = this.right.preSearch(no);
        }
        return result;
    }

    //中序查找
    public HeroNode infixSearch(int no) {
        HeroNode result = null;
        if (null != this.left) {
            result = this.left.infixSearch(no);
        }
        if (null != result) {
            return result;
        }
        if (this.no == no) {
            return this;
        }
        if (null != this.right) {
            result = this.right.infixSearch(no);
        }
        return result;
    }

    //后序查找
    public HeroNode postSearch(int no) {
        HeroNode result = null;
        if (null != this.left) {
            result = this.left.postSearch(no);
        }
        if (null != result) {
            return result;
        }
        if (null != this.right) {
            result = this.right.postSearch(no);
        }
        if (null != result) {
            return result;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }

    //删除节点
    public void delNode(int no) {
        if (null != this.left && this.left.no == no) {
            this.left = null;
            return;
        }
        if (null != this.right && this.right.no == no) {
            this.right = null;
            return;
        }
        if (null != this.left) {
            this.left.delNode(no);
        }
        if (null != this.right) {
            this.right.delNode(no);
        }
    }

}