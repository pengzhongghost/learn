package leetcode题目.位运算;

public class 位1的个数 {
    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
     * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * <p>
     * 提示：
     * <p>
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
     * 输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
     * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
     * <p>
     * 提示：
     * 输入必须是长度为 32 的 二进制串 。
     */
    public static void main(String[] args) {
        System.out.println(hammingWeight(34));
    }

    //2的次幂只有一个1，当n按位与2的次幂！=0，说明有一位是1
    public static int hammingWeight(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                num++;
            }
        }
        return num;
    }

    public static int hammingWeight01(int n) {
        return Integer.bitCount(n);
    }
}
