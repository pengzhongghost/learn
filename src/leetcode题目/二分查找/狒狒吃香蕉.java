package leetcode题目.二分查找;

public class 狒狒吃香蕉 {
    /**
     * https://leetcode-cn.com/problems/nZZqjQ/
     * 狒狒吃香蕉
     * 狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
     * 狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
     * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
     * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
     * <p>
     * 示例 1：
     * 输入：piles = [3,6,7,11], h = 8
     * 输出：4
     */
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        int l = 1, r = maxPile;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (getEattingHour(mid, piles) > h) {
                // 当以 mid 速度吃完香蕉的时间 > h , 则提速要提升, left 指针右移
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    // 计算以 speed 的速度吃完香蕉的时间
    private static int getEattingHour(int speed, int[] piles) {
        int hour = 0;
        // 由于,每次最多吃一堆, 所以吃完香蕉的总时间需要 计算每堆香蕉吃完的时间
        for (int pile : piles) {
            // 每堆香蕉吃完的时间 = 这一堆香蕉数/吃的速度, 结果向上取整
            hour += (pile + speed - 1) / speed;
        }
        return hour;
    }
}
