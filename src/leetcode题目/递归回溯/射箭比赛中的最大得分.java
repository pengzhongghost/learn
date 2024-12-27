package leetcode题目.递归回溯;

import java.util.Arrays;

public class 射箭比赛中的最大得分 {

    /**
     * https://leetcode.cn/problems/maximum-points-in-an-archery-competition/description/?envType=problem-list-v2&envId=backtracking
     */

    public static void main(String[] args) {
        int[] result = maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0});
        System.out.println(Arrays.toString(result));
    }

    static int result = 0;
    static int otherNumArrows = 0;
    static int[] resList = new int[12];

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(numArrows, 0, aliceArrows, 0, new int[12]);
        if(0 != otherNumArrows) {
            resList[0] = otherNumArrows;
        }
        return resList;
    }

    private static void dfs(int numArrows, int index, int[] aliceArrows, int temp, int[] tempList) {
        if (index == aliceArrows.length) {
            if (temp > result) {
                result = temp;
                otherNumArrows = numArrows;
                resList = Arrays.copyOf(tempList, tempList.length);

            }
            return;
        }
        dfs(numArrows, index + 1, aliceArrows, temp, tempList);
        if (numArrows >= aliceArrows[index] + 1) {
            int t = aliceArrows[index];
            tempList[index] += aliceArrows[index] + 1;
            dfs(numArrows - aliceArrows[index] - 1, index + 1, aliceArrows, temp + index, tempList);
            aliceArrows[index] = t;
            tempList[index] -= aliceArrows[index] + 1;
        }
    }

}
