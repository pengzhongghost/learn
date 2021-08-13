package 排序.希尔排序;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort02(arr);
        System.out.println(Arrays.toString(arr));
        //测试8万条数据都排序时间
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            test[i] = (int) (Math.random() * 8000000);
        }
        //System.out.println(Arrays.toString(test));
        long start = System.currentTimeMillis();
        sort02(test);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));

    }

    //希尔排序(交换法)
    public static void sort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //将数组分为5组
            for (int i = gap; i < arr.length; i++) {
                //步长为5，分为5组
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的元素，则交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //希尔排序推导过程(交换法)
    public static void shellSort(int[] arr) {
        int temp;
        //将数组分为5组
        for (int i = 5; i < arr.length; i++) {
            //步长为5，分为5组
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的元素，则交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮排序：" + Arrays.toString(arr));
        //将数组分为两组
        for (int i = 2; i < arr.length; i++) {
            //步长为2，分为2组
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序第二轮排序：" + Arrays.toString(arr));
        //将数组分为一组
        for (int i = 1; i < arr.length; i++) {
            //步长为2，分为2组
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第三轮排序：" + Arrays.toString(arr));
    }

    //对交换式对排序进行优化->移位法
    public static void sort02(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在对组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }


}
