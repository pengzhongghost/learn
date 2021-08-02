package 链表.约瑟夫问题;

public class Josefu {
    public static void main(String[] args) {
        CircleLinkedList list = new CircleLinkedList();
        list.add(5);
        list.showBoy();
        list.countBoy(1,2,5);
    }
}

//创建环形的单向链表
class CircleLinkedList {

    private Boy first = null;

    //添加元素
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("num的值不正确");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.next = first;
                cur = first;
            } else {
                cur.next = boy;
                boy.next = first;
                cur = boy;
            }
        }
    }

    //遍历链表
    public void showBoy() {
        if (null == first) {
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf(cur.no + "\t");
            if (first == cur.next) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * @param startNum 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示有多少小孩在圈中
     */
    public void countBoy(int startNum, int countNum, int nums) {
        if (null == first || startNum < 1 || startNum > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //使用一个helper指针，使这个指针指向环形链表最后一个节点
        Boy helper = first;
        while (true) {
            if (first == helper.next) {
                break;
            }
            helper = helper.next;
        }
        //从第几个人开始报数
        for (int i = 0; i < startNum - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while (true) {
            //圈中只有一人
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first.no + "出圈");
            first = first.next;
            helper.next = first;
        }
        System.out.println("最后一个小孩是" + first.no);
    }

    //创建节点
    class Boy {
        //编号
        private int no;
        //指向下一个小孩
        private Boy next;

        public Boy(int no) {
            this.no = no;
        }
    }
}


