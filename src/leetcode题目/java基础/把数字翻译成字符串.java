package leetcode题目.java基础;

public class 把数字翻译成字符串 {
    /**
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
     * 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11
     * 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        //获取输入数字的余数，然后递归的计算翻译方法
        int tmp = num % 100;
        if (tmp <= 9 || tmp >= 26) {
            //如果小于等于9或者大于等于26的时候，余数不能按照2位数字组合，比如56，
            // 只能拆分为5和6；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译。
            return translateNum(num / 10);
        } else {
            // ba=[10, 25]时，既可以当做一个字母，也可以当做两个字母
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }
}
