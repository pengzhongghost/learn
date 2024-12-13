package 剑指offer;

import java.util.Arrays;

public class 报数 {

    /**
     * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/description/
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = countNumbers(2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] countNumbers(int cnt) {
        int size = (int) (Math.pow(10, cnt) - 1);
        int[] res = new int[size];
        for(int i = 1; i <= size; i++){
            res[i-1] = i;
        }
        return res;
    }

}
