package 查找.插值查找;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int sort = sort(arr, 0, arr.length - 1, 30);
        System.out.println(sort);
    }

    public static int sort(int[] arr, int left, int right, int findVal) {
        //不仅仅是优化，而且是必须要的判断，否则可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (midVal == findVal) {
            return mid;
        } else if (midVal > findVal) {
            return sort(arr, left, midVal - 1, findVal);
        } else {
            return sort(arr, mid + 1, right, findVal);
        }
    }

}
