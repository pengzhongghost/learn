package 树.二叉排序树;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int i : arr) {
            tree.add(new Node(i));
        }
        tree.deleteNode(1);
        tree.deleteNode(3);
        tree.deleteNode(5);
        tree.deleteNode(7);
        tree.deleteNode(9);
        tree.deleteNode(10);
        tree.deleteNode(12);
        //tree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

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