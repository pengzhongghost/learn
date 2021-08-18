package 查找.二分查找;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用二分查找的前提是该数组必须是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = binarySearch(arr, 0, arr.length - 1, 89);
        System.out.println(i);
        int[] arr2 = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        List<Integer> list = binarySearch2(arr2, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    //如果有多个相同的，只能返回一个
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findVal == midValue) {
            return mid;
        } else if (findVal > midValue) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return binarySearch(arr, left, mid - 1, findVal);
        }
    }

    //如果有多个相同的，只能返回一个
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findVal == midValue) {
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            //因为是有序的数据，向左扫描是否有相同的
            while (true) {
                if (temp < 0 || midValue != arr[temp]) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            temp = mid + 1;
            //向右扫描是否有相同的
            while (true) {
                if (temp > arr.length - 1 || midValue != arr[temp]) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            resIndexList.add(mid);
            return resIndexList;
        } else if (findVal > midValue) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else {
            return binarySearch2(arr, left, mid - 1, findVal);
        }
    }
}
