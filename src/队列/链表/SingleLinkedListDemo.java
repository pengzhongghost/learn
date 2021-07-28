package 队列.链表;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
//        list.add(new HeroNode(1, "宋江", "豹子头"));
//        list.add(new HeroNode(2, "林冲", "及时雨"));
//        list.add(new HeroNode(3, "李逵", "大刀"));
//        list.add(new HeroNode(4, "吕布", "奉先"));
//        list.list();
        list.addByOrder(new HeroNode(3, "宋江", "豹子头"));
        list.addByOrder(new HeroNode(1, "林冲", "及时雨"));
        list.addByOrder(new HeroNode(2, "李逵", "大刀"));
        list.addByOrder(new HeroNode(4, "吕布", "奉先"));
        list.list();
        list.update(new HeroNode(3, "刘备", "玄德"));
        list.list();
        list.update(new HeroNode(5, "刘备", "玄德"));
        list.list();
        list.delete(1);
        list.delete(3);
        list.delete(5);
        list.list();
    }
}

/**
 * 1.链表是已节点的方式来存储，是链式存储
 * 2.每个节点包含data域，next域，指向下一个节点
 * 3.链表的各个节点不一定是连续内存
 * 4.链表分带头点的链表和没有头节点的链表，根据实际的需求来确定
 */
class SingleLinkedList {
    //初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (null != temp.getNext()) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    //遍历所有节点
    public void list() {
        if (null == head.getNext()) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (null != temp) {
            System.out.printf(temp + "\t");
            temp = temp.getNext();
        }
        System.out.println();
    }

    //有顺序的添加，按照no排名添加
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        while (null != temp) {
            //当前编号已经存在
            if (node.getNo() == temp.getNo()) {
                break;
                //当前编号>
            } else if (node.getNo() > temp.getNo()) {
                if (null == temp.getNext()) {
                    temp.setNext(node);
                } else {
                    if (node.getNo() < temp.getNext().getNo()) {
                        HeroNode after = temp.getNext();
                        temp.setNext(node);
                        node.setNext(after);
                    }
                }
            }
            temp = temp.getNext();
        }

    }

    //修改节点的信息,根据新节点的编号修改
    public void update(HeroNode node) {
        //判断为空
        if (null == head.getNext()) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (null != temp) {
            if (temp.getNo() == node.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
        } else {
            System.out.println("没有找到此编号的节点：" + node);
        }
    }

    //删除节点
    public void delete(int num) {
        //判断为空
        if (null == head.getNext()) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (null != temp.getNext()) {
            if (num == temp.getNext().getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("没有这个编号：" + num);
        }
    }

}

class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}