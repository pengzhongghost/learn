package 中级提升;

import java.util.HashMap;
import java.util.Map;

public class 数组切成四个部分 {

    /**
     * 给定一个长度大于3的数组arr，
     * 返回该数组能不能分成4个部分，
     * 并且每个部分的累加和相等
     */

    public static void main(String[] args) {

    }

    public static boolean canSplit(int[] arr) {
        if (null == arr || arr.length < 7) {
            return false;
        }
        //前缀和map
        Map<Integer, Integer> map = new HashMap<>();
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            map.put(sum, i);
            sum += arr[i];
        }
        //左侧和
        int lsum = arr[0];
        for (int i = 1; i < arr.length - 5; i++) {
            //是否包含第二刀
            int checkSum = lsum * 2 + arr[i];
            if (map.containsKey(checkSum)) {
                Integer i2 = map.get(checkSum);
                checkSum += lsum + arr[i2];
                if (map.containsKey(checkSum)) {
                    Integer i3 = map.get(checkSum);
                    if (checkSum + arr[i3] +lsum == sum) {
                        return true;
                    }
                }
            }
            lsum += arr[i];
        }
        return false;
    }

}
