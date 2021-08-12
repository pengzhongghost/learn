package 排序.选择排序;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        //测试8万条数据都排序时间
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            test[i] = (int) (Math.random() * 8000000);
        }
        //System.out.println(Arrays.toString(test));
        long start = System.currentTimeMillis();
        sort(test);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));

    }

    //选择排序都时间复杂度是O(n^2)
    public static void sort(int[] arr) {
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            temp = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
