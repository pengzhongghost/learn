package leetcode题目.逆波兰表达式;

import java.util.Arrays;
import java.util.Stack;

public class 小行星碰撞 {
    /**
     * https://leetcode-cn.com/problems/XagZNi/
     * 小行星碰撞
     * 给定一个整数数组 asteroids，表示在同一行的小行星。
     * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
     * 每一颗小行星以相同的速度移动。找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
     * 如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
     * <p>
     * 示例 1：
     * 输入：asteroids = [5,10,-5]
     * 输出：[5,10]
     * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
     */
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        asteroids = new int[]{-2, -2, 1, -2};
        int[] res = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int t = 0;
        while (t < asteroids.length) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[t] > 0) {
                stack.push(asteroids[t]);
            } else if (stack.peek() <= -asteroids[t]) {
                //todo -2, -2, 1, -2  最后一个是-2的情况，不continue无法将之放入栈中
                if (stack.pop() < -asteroids[t]) continue;
            }
            t++;
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
