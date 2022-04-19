package leetcode题目.java基础;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最小时间差 {
    /**
     * https://leetcode-cn.com/problems/569nqc/
     * 最小时间差
     * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
     * <p>
     * 示例 1：
     * 输入：timePoints = ["23:59","00:00"]
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：timePoints = ["00:00","23:59","00:00"]
     * 输出：0
     */
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        List<Integer> nums = new ArrayList<>();
        for (String time : timePoints) {
            String[] split = time.split(":");
            nums.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        Collections.sort(nums);
        nums.add(nums.get(0) + 24 * 60);
        for (int i = 1; i < nums.size(); i++) {
            res = Math.min(res, nums.get(i) - nums.get(i - 1));
        }
        return res;
    }
}
