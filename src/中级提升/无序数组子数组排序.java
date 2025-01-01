package 中级提升;

public class 无序数组子数组排序 {

    /**
     * 给定一个无序数组arr，如果只能对一个子数组进行排序，
     * 但是想让数组整体都有序，求需要排序的最短子数组长度。
     * 例如:arr =[1,5,3,4,2.6,7]返回4，因为只有[5,3,4,2]需要排序
     */
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 15, 9, 10};
//        nums = new int[]{1, 2, 3, 4};
//        nums = new int[]{1, 3, 2, 2, 2};
//        nums = new int[]{2, 3, 3, 2, 4};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int right = 0, left = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < maxn) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (nums[nums.length - 1 - i] > minn) {
                left = nums.length - 1 - i;
            } else {
                minn = nums[nums.length - 1 - i];
            }
        }
        return right < left ? -1 : right - left + 1;
    }

}
