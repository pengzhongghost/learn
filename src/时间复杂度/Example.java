package 时间复杂度;

public class Example {
    public static void main(String[] args) {

    }

    /**
     * (1)常数阶O(1)
     * 无论执行了多少行，只要没有循环等复杂结构，那这个代码的时间复杂度就都是O(1)
     */
    public void one() {
        int i = 1;
        int j = 2;
        ++i;
        j++;
        int m = i + j;
    }

    /**
     * (2)对数阶O(log2n)
     * <p>
     * i每次都乘以2，越来越接近n了, 2的n次方=n
     */
    public void two() {
        int i = 1;
        int n = 50;
        while (i < n) {
            i = i * 2;
        }
    }

    /**
     * (3)线性阶O(n)
     * 单纯的for循环就是线性阶
     */
    public void three() {
        int n = 10;
        int j = 1;
        for (int i = 0; i < n; i++) {
            j += i;
        }
    }

    /**
     * 线性对数阶O(nlogN)，就是将对数阶循环了n次
     */
    public void four() {
        int n = 50;
        for (int i = 0; i < 10; i++) {
            while (i < n) {
                i = i * 2;
            }
        }
    }

    /**
     * 平方阶O(n2)
     * 双层for循环
     * <p>
     * 立方阶O(n3),K次方阶O(n^k)
     * 三层循环，k层循环
     */
    public void five() {
        //执行了10次
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }
    }

}
