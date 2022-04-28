package leetcode题目.位运算;

public class 翻转数位 {
    /**
     * https://leetcode-cn.com/problems/reverse-bits-lcci/
     * 翻转数位
     * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，
     * 找出你能够获得的最长的一串1的长度。
     *
     * 示例 1：
     * 输入: num = 1775(110111011112)
     * 输出: 8
     *
     * 示例 2：
     * 输入: num = 7(01112)
     * 输出: 4
     */
    //  0111
    public static void main(String[] args) {
        System.out.println(reverseBits(1775));
    }

    public static int reverseBits(int num) {
        int curLen = 0, preLen = 0, maxLen = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }

    public static int reverseBits02(int num) {
        int[] ant = new int[32];
        int idx = 0, maxLen = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                ant[idx]++;
            } else {
                idx++;
            }
            num >>= 1;
        }
        for (int i = 0; i < ant.length - 1; i++) {
            //todo 可以将一个数位从0变为1
            maxLen = Math.max(maxLen, ant[i] + ant[i + 1] + 1);
        }
        return maxLen;
    }
}
