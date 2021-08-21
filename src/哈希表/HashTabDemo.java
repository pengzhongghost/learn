package 哈希表;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        hashTab.add(1, new Emp(1, "李逵"));
        hashTab.add(2, new Emp(2, "宋江"));
        hashTab.add(3, new Emp(3, "林冲"));
        hashTab.add(8, new Emp(8, "吴用"));
        hashTab.list();
        System.out.println(hashTab.get(8));
    }
}

//存储的对象
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//链表
class MyLinkedList {

    private Emp head;

    //添加方法
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = emp;
    }

    //遍历方法
    public void list(int i) {
        if (null == head) {
            System.out.println("第" + i + "条链表为空");
            return;
        }
        Emp temp = head;
        while (null != temp) {
            System.out.printf(temp + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public Emp get(int i) {
        if (null == head) {
            return null;
        }
        Emp temp = head;
        while (null != temp) {
            if (temp.id == i) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}

//哈希表
class HashTab {
    private MyLinkedList[] empLinkedListArr;
    private int size;

    //构造器
    public HashTab(int size) {
        this.size = size;
        this.empLinkedListArr = new MyLinkedList[size];
        //分别初始化每个链表,数组中的每个都需要创建链表
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new MyLinkedList();
        }
    }

    //放入不同的数组链表中
    public void add(int id, Emp emp) {
        int empLinkedListNo = hashFun(id);
        empLinkedListArr[empLinkedListNo].add(emp);
    }

    //获取
    public Emp get(int id) {
        int i = hashFun(id);
        return empLinkedListArr[i].get(id);
    }

    //遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list(i + 1);
        }
    }

    //编写散列函数，使用简单取模法
    public int hashFun(int id) {
        return id % size;
    }

}