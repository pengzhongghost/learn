package 递归;

public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(test(5));
    }

    public static int test(int n) {
        if (n > 2) {
            return test(n - 1) * n;
        }
        return n;
    }

}
