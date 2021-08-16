package 排序.归并排序;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        //归并排序需要一个额外的空间
        sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
        //测试8万条数据都排序时间
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            test[i] = (int) (Math.random() * 8000000);
        }
        //System.out.println(Arrays.toString(test));
        long start = System.currentTimeMillis();
        sort(test, 0, test.length - 1, new int[test.length]);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));
    }

    //分+合的方法
    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向做递归进行分解
            sort(arr, left, mid, temp);
            //向右递归进行分解
            sort(arr, mid + 1, right, temp);
            //到合并时
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr    排序的数组
     * @param left   左边有序序列大的初始索引
     * @param right  右边索引
     * @param middle 中间索引
     * @param temp   做中转的数组
     */
    public static void merge(int[] arr, int left, int right, int middle, int[] temp) {
        //左边有序序列的初始化索引
        int i = left;
        //右边有序序列的初始化索引
        int j = middle + 1;
        //指向temp数组的当前索引
        int t = 0;

        while (i <= middle && j <= right) {
            //如果左边的有序序列的元素小于右边的有序序列的当前元素
            //则将左边的当前元素拷贝到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //左边的有序序列还有剩余的元素，就全部填充到temp中
        while (i <= middle) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        //右边的有序序列还有剩余的元素，就全部填充到temp中
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将temp数组拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
