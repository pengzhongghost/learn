package 中级提升;

public class 累加范围上的数缺什么数_9 {

    /**
     * 给定一个有序的正数数组arr和一个正数range，如果可以自由选择arr中的数字，
     * 想累加得到 1~range 范围上所有的数，返回arr最少还缺几个数。
     *
     * 【举例】
     * arr ={1,2,3,7}，range = 15
     * 想累加得到 1~15 范围上所有的数，arr 还缺 14 这个数，所以返回1arr ={1,5,7}，range = 15
     * 想累加得到1~15 范围上所有的数，arr 还缺2和 4，所以返回2
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,7};
        int result = minPatches(arr, 15);
        System.out.println(result);
    }

    public static int minPatches(int[] arr, int range) {
        long touch = 0;
        int patches = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > touch + 1) {
                touch += touch + 1;
                patches++;
            }
            touch += arr[i];
            if (touch >= range) {
                return patches;
            }
        }
        while (range >= touch + 1) {
            touch += touch + 1;
            patches++;
        }
        return patches;
    }

}
