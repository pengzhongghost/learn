package 查找.斐波那契查找;

import java.util.Arrays;

public class FibonacciSearch {
    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(search(arr, 1234));
    }

    //非递归的方式得到一个斐波那契数量
    public static int[] fib() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int[] fib = fib();
        while (high > fib[k] - 1) {
            k++;
        }
        //{1, 8, 10, 89, 1000, 1234}=>{1, 8, 10, 89, 1000, 1234,0,0,0}
        int[] temp = Arrays.copyOf(arr, fib[k]);
        //{1, 8, 10, 89, 1000, 1234}=>{1, 8, 10, 89, 1000, 1234,1234,1234,1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                //1。全部元素=前面的元素+后面的元素
                //2。f[k]=f[k-1]+f[k-2]
                //前面有k-1个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                //即在f[k-1]的前面继续查找k--
                //即下次循环mid=f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                //f[k]=f[k-1]+f[k-2]
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

}
