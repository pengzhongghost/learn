package 树.平衡二叉树;

public class AvlTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        AVLTree tree = new AVLTree();
//        for (int i : arr) {
//            tree.add(new Node(i));
//        }
//        tree.infixOrder();
//        System.out.println(tree.getRoot().height());
//        System.out.println(tree.getRoot().leftHeight());
//        System.out.println(tree.getRoot().rightHeight());
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree tree = new AVLTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }
        tree.infixOrder();
        System.out.println(tree.getRoot().height());
        System.out.println(tree.getRoot().leftHeight());
        System.out.println(tree.getRoot().rightHeight());
        System.out.println(tree.getRoot());
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //添加节点
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //删除节点
    public void deleteNode(int value) {
        if (root == null) {
            return;
        }
        Node targetNode = search(value);
        //如果没有要删除的节点，直接return
        if (null == targetNode) {
            return;
        }
        //说明删除的就是root节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        //找到父节点
        Node parent = searchParent(value);
        //如果要删除的是叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            //判断targetNode是父节点的左子节点还是右子节点
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {
            //删除有两棵子树的节点
            //从右子树找最小的
            int minValue = delRightTreeMin(targetNode.right);
            targetNode.value = minValue;
        } else {
            //删除有一颗子树的节点
            if (targetNode.left == null) {
                if (parent != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }
            } else if (targetNode.right == null) {
                if (parent != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            }
        }

    }

    //删除右子树上最小的节点，并返回该值
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        //这是target指向了最小的节点
        deleteNode(target.value);
        //删除的是树的结构，对象还在
        return target.value;
    }
}

class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树度高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前节点的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转的方法
    public void leftRotate() {
        //创建新的节点,以当前根节点的值
        Node node = new Node(value);
        //把新的节点的左子树设置为当前节点的左子树
        node.left = this.left;
        //把新的节点的右子树设置为为当前的节点的右子树的左子树
        node.right = this.right.left;
        //把当前节点的值替换成右子树的值
        this.value = this.right.value;
        //把当前节点的右子树设置成为右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子树设置新的节点
        this.left = node;
    }

    //右旋转
    public void rightRotate() {
        Node node = new Node(value);
        node.right = this.right;
        node.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = node;
    }

    //添加节点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //当添加完一个节点之后.右子树的高度减去左子树的高度>1，则需要左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果他的右子树的左子树大于他的右子树的右子树的高度
            if (right != null && right.left.height() > right.right.height()) {
                //先对当前节点的右子树进行右旋转
                right.rightRotate();
            }
            leftRotate();
            return;
        }
        //当添加完一个节点之后.左子树的高度减去右子树的高度>1，则需要右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果他的左子树的右子树的高度大于他的左子树的高度
            if (left != null && left.right.height() > left.left.height()) {
                //先对当前节点的左子树进行左旋转
                left.leftRotate();
            }
            rightRotate();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除的节点的父节点的
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}