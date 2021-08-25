package 树.堆排序;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组升序排列，则使用大顶堆
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    //编写堆排序的方法
    public static void heapSort(int[] arr) {
        /**adjustHeap(arr,1,arr.length);
         System.out.println(Arrays.toString(arr));
         adjustHeap(arr,0,arr.length);
         System.out.println(Arrays.toString(arr));*/
        //第一次获得最大的值的大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //此时根节点往下的都是大顶堆,所以下面只需要从上往下调整
        //数组逐渐变小
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    //将一个数组调整成为大顶堆

    /**
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //左子节点的左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //左子节点<右子节点的值
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            //子节点大于父节点
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;//此处i赋值他的子节点的值继续比较
            } else {
                //此处敢break是因为只会比较此非叶子节点子树
                break;
            }
        }
        //此时的i已经是最终交换的位置
        arr[i] = temp;
    }

}
