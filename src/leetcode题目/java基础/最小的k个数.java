package leetcode题目.java基础;

import java.util.Arrays;

public class 最小的k个数 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] res = getLeastNumbers(arr, 4);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
