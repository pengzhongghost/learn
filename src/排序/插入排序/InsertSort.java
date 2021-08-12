package 排序.插入排序;

import java.util.Arrays;

public class InsertSort {
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

    public static void sort(int[] arr) {
        int insertValue = 0;
        int beforeIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            beforeIndex = i - 1;
            while (beforeIndex >= 0 && insertValue < arr[beforeIndex]) {
                arr[beforeIndex + 1] = arr[beforeIndex];
                beforeIndex--;
            }
            //优化，找到的就是当前位置
            if (beforeIndex + 1 != i) {
                arr[beforeIndex + 1] = insertValue;
            }
        }
    }

}
