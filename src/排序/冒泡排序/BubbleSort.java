package 排序.冒泡排序;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 2};
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
        //是否发生过交换
        boolean flag = false;
        //时间复杂度是O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //一次都没有发生过交换
            if (!flag) {
                break;
            } else {
                //重置，进行下次判断
                flag = false;
            }
        }
    }

}
