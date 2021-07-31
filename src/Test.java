
public class Test {
    public static void main(String[] args) {
        MyLinkedQueueV2 queue = new MyLinkedQueueV2();
//        queue.addQueue(new HeroNode(1, "宋江", "豹子头"));
//        queue.addQueue(new HeroNode(3, "李逵", "大刀"));
//        queue.addQueue(new HeroNode(2, "吕布", "奉先"));
//        queue.showQueue();
//        System.out.println(queue.getQueue());
//        System.out.println(queue.getQueue());
//        System.out.println(queue.getQueue());
//        System.out.println(queue.getQueue());
//        queue.addQueue(new HeroNode(1, "宋江", "豹子头"));
//        queue.showQueue();
        queue.addByOrder(new HeroNodeV2(1, "宋江", "豹子头"));
        queue.addByOrder(new HeroNodeV2(3, "李逵", "大刀"));
        queue.addByOrder(new HeroNodeV2(2, "吕布", "奉先"));
        queue.showQueue();

    }
}

class MyLinkedQueueV2 {

    private HeroNodeV2 head = new HeroNodeV2(0, null, null);

    public void addQueue(HeroNodeV2 node) {
        HeroNodeV2 temp = head;
        while (null != temp) {
            if (null == temp.next) {
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    //只需要和temp.next比较，只要比他大，就在他的前面插入此节点,否则继续便利
    public void addByOrder(HeroNodeV2 node) {
        HeroNodeV2 temp = head;
        while (true) {
            //temp.next为null，可以插入数据
            if (temp.next == null) {
                break;
            }
            //temp.next的id>当前node的id
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                System.out.println("此编号已经存在" + node);
                return;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public HeroNodeV2 getQueue() {
        if (null != head.next) {
            HeroNodeV2 temp = head.next;
            head.next = head.next.next;
            return temp;
        }
        return null;
    }

    public void showQueue() {
        HeroNodeV2 temp = head;
        if (null == temp.next) {
            System.out.println("队列为空");
            return;
        }
        while (null != temp.next) {
            System.out.printf(temp.next + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

}

class HeroNodeV2 {

    public int id;

    public String name;

    public String nickName;

    public HeroNodeV2 next;

    public HeroNodeV2(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}