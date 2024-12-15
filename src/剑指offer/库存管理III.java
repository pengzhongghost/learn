package 剑指offer;

import java.util.Arrays;

public class 库存管理III {

    public static void main(String[] args) {
        int[] stock = {2,5,7,4};
        int[] ints = inventoryManagement(stock, 1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
     */

    public static int[] inventoryManagement(int[] stock, int cnt) {
        sort(stock, 0, stock.length - 1, new int[stock.length]);
        int[] res = new int[cnt];
        for(int i =0; i< cnt; i++) {
            res[i] = stock[i];
        }
        return res;
    }

    private static void sort(int[] stock, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            sort(stock, left, mid, temp);
            sort(stock, mid + 1, right, temp);
            sort(stock, left, right, mid, temp);
        }
    }

    private static void sort(int[] stock, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid+1;
        int index = 0;
        while(i<=mid&& j<=right) {
            if(stock[i]<stock[j]) {
                temp[index++]=stock[i++];
            } else {
                temp[index++]=stock[j++];
            }
        }
        while(i<=mid) {
            temp[index++]=stock[i++];
        }
        while(j<=right) {
            temp[index++]=stock[j++];
        }
        index = 0;
        i = left;
        while(i <= right) {
            stock[i++] = temp[index++];
        }
    }

}
