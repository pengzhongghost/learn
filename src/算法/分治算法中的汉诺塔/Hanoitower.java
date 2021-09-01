package 算法.分治算法中的汉诺塔;

public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(3, 'A', 'B', 'C');
    }

    public static void hanoitower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //1.先把最上面的盘a->b,移动过程会使用到c
            hanoitower(num - 1, a, c, b);
            //2.把最下面的盘a->c
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3.把b所有盘->c,移动过程使用到a
            hanoitower(num - 1, b, a, c);
        }
    }

}
