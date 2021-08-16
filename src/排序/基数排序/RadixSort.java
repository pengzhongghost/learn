package 排序.基数排序;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //空间换时间
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶🪣实际存放了多少数据，定义一个一维数组来记录每个桶的数据个数
        int[] bucketElmentCounts = new int[10];
        int index = 0;
        //找到最大对数据的位数
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int maxLength = (max + "").length();
        for (int l = 0, n = 1; l < maxLength; l++, n *= 10) {
            //第二轮处理，对十位位数对处理
            for (int i = 0; i < arr.length; i++) {
                //取到每个元素个位的值
                int digitOfElement = arr[i] / n % 10;
                //放入对应的桶中
                bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[i];
                bucketElmentCounts[digitOfElement]++;
            }
            //遍历桶中数据，放入到原数组
            index = 0;
            for (int i = 0; i < bucketElmentCounts.length; i++) {
                if (bucketElmentCounts[i] != 0) {
                    //有数据则循环第i个桶
                    for (int j = 0; j < bucketElmentCounts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                //第一轮处理后，需要将之置为0
                bucketElmentCounts[i] = 0;
            }
        }

    }


    /**
     * 推导过程
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //空间换时间
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶🪣实际存放了多少数据，定义一个一维数组来记录每个桶的数据个数
        int[] bucketElmentCounts = new int[10];
        //第一轮，针对每个元素的个位进行排序处理
        for (int i = 0; i < arr.length; i++) {
            //取到每个元素个位的值
            int digitOfElement = arr[i] % 10;
            //放入对应的桶中
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[i];
            bucketElmentCounts[digitOfElement]++;
        }
        //遍历桶中数据，放入到原数组
        int index = 0;
        for (int i = 0; i < bucketElmentCounts.length; i++) {
            if (bucketElmentCounts[i] != 0) {
                //有数据则循环第i个桶
                for (int j = 0; j < bucketElmentCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            //第一轮处理后，需要将之置为0
            bucketElmentCounts[i] = 0;
        }
        System.out.println("第一轮，对个位的排序处理 arr = " + Arrays.toString(arr));
        //第二轮处理，对十位位数对处理
        for (int i = 0; i < arr.length; i++) {
            //取到每个元素个位的值
            int digitOfElement = arr[i] / 10 % 10;
            //放入对应的桶中
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[i];
            bucketElmentCounts[digitOfElement]++;
        }
        //遍历桶中数据，放入到原数组
        index = 0;
        for (int i = 0; i < bucketElmentCounts.length; i++) {
            if (bucketElmentCounts[i] != 0) {
                //有数据则循环第i个桶
                for (int j = 0; j < bucketElmentCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            //第一轮处理后，需要将之置为0
            bucketElmentCounts[i] = 0;
        }
        System.out.println("第二轮，对十位的排序处理 arr = " + Arrays.toString(arr));

        //第三轮处理，对百位数对处理
        for (int i = 0; i < arr.length; i++) {
            //取到每个元素个位的值
            int digitOfElement = arr[i] / 100 % 10;
            //放入对应的桶中
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[i];
            bucketElmentCounts[digitOfElement]++;
        }
        //遍历桶中数据，放入到原数组
        index = 0;
        for (int i = 0; i < bucketElmentCounts.length; i++) {
            if (bucketElmentCounts[i] != 0) {
                //有数据则循环第i个桶
                for (int j = 0; j < bucketElmentCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            //第一轮处理后，需要将之置为0
            bucketElmentCounts[i] = 0;
        }
        System.out.println("第三轮，对百位的排序处理 arr = " + Arrays.toString(arr));


    }

}
