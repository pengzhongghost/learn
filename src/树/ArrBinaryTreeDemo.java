package 树;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder(0);//1,2,4,5,3,6,7
    }

}

//编写一个顺序存储二叉树
class ArrBinaryTree {
    private int[] arr;//存储数据节点都数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    public void preOrder(int index) {
        if (null == arr || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        //向左递归
        if ((2*index+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归
        if ((2*index+2)<arr.length){
            preOrder(2*index+2);
        }
    }

}