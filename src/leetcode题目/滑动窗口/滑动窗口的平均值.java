package leetcode题目.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class 滑动窗口的平均值 {
    /**
     * https://leetcode-cn.com/problems/qIsx9U/
     * 滑动窗口的平均值
     * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
     * 实现 MovingAverage 类：
     * MovingAverage(int size) 用窗口大小 size 初始化对象。
     * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，
     * 请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
     * <p>
     * 示例：
     * 输入：
     * inputs = ["MovingAverage", "next", "next", "next", "next"]
     * inputs = [[3], [1], [10], [3], [5]]
     * 输出：
     * [null, 1.0, 5.5, 4.66667, 6.0]
     * <p>
     * 解释：
     * MovingAverage movingAverage = new MovingAverage(3);
     * movingAverage.next(1); // 返回 1.0 = 1 / 1
     * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
     * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
     * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
     */
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }

    static class MovingAverage {

        List<Integer> list;
        int size;
        double res;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.list = new ArrayList<>(size);
            this.size = size;
            this.res = 0;
        }

        public double next(int val) {
            if (list.size() == size) {
                res -= list.get(0);
                list.remove(0);
            }
            list.add(val);
            res += val;
            return res / list.size();
        }
    }
}
