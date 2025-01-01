package 中级提升;

public class 随机数的概率问题_8 {

    /**
     * 假设函数 Math.random()等概率随机返回一个在[0,1)范围上的数，那么我们知道，
     * 在[0,x)区 间上的数出现的概率为 x(0<x≤1)。
     * 给定一个大于 0 的整数 k并且可以使用 Math.random()函数，
     * 请实现一个函数依然返回在[0.1)范围上的数，但是在[0,x)区间上的数出现的概率为x^k(0<x≤ 1)。
     */
    public static void main(String[] args) {
        int testTime = 10000000;
        double x = 0.6;
        int count = 0;
        for (int i = 0; i < testTime; i++) {
            //if (Math.random() < x) {
            //两次Math.random()取最大，则降低一半的概率
            if (getNum(2) < x) {
                count++;
            }
        }
        System.out.println((double) (count) / (double) (testTime));
    }

    private static double getNum(int k) {
        double result = 0;
        for (int i = 0; i < k; i++) {
            result = Math.max(result, Math.random());
        }
        return result;
    }

}
