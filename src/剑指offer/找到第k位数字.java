package 剑指offer;

public class 找到第k位数字 {

    public static void main(String[] args) {
        int result = findKthNumber(12);
        System.out.println(result);
    }

    /**
     * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
     */

    public static int findKthNumber(int k) {
        long start = 1;
        long count = 9;
        int digit = 1;
        while (k > count) {
            k -= count;
            start *= 10;
            digit++;
            count = digit * start * 9;
        }
        //start是第一位，所以k应该-1
        long num = start + (k - 1) / digit;
        //-0是因为前面是字符了，要转成数字
        return ("" + num).charAt((k - 1) % digit) - '0';
    }

}
