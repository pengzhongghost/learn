package 排序.快速排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //测试8万条数据都排序时间
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            test[i] = (int) (Math.random() * 8000000);
        }
        //System.out.println(Arrays.toString(test));
        long start = System.currentTimeMillis();
        sort(test, 0, test.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));
    }

    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            //在pivot的左边找到大于等于pivot的值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边找到小雨等于pivot的值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明pivot两边的值已经按照左边全是小于等于pivot的值，右边全是大于等于pivot的值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //此处理是为了让这个值放在无限接近于pivot的位置
            //如果交换完后，发现这个arr[l]==pivot， r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r]==pivot， l++，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //如果l==r，则必须l++，r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            sort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            sort(arr, l, right);
        }
    }

}
