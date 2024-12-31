package 中级提升;

public class 跳跃游戏 {

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1, 2, 1, 5};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int step = 0;
        //当前这一步能到达的最右边界
        int curMaxRight = 0;
        //下一步能到达的最右边界
        int nextMaxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curMaxRight < i) {
                curMaxRight = nextMaxRight;
                step++;
            }
            nextMaxRight = Math.max(nextMaxRight, nums[i] + i);
        }
        return step;
    }

}
