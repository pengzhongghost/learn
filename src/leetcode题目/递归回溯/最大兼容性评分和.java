package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/26
 */
public class 最大兼容性评分和 {

    /**
     * https://leetcode.cn/problems/maximum-compatibility-score-sum/description/?envType=problem-list-v2&envId=backtracking
     */
    int maxCompatibilitySum = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        dfs(students, mentors, 0, new boolean[students.length], 0);
        return maxCompatibilitySum;
    }

    private void dfs(int[][] students, int[][] mentors, int index, boolean[] isVisited, int sum) {
        if (index == mentors.length) {
            maxCompatibilitySum = Math.max(maxCompatibilitySum, sum);
            return;
        }
        for (int i = 0; i < students.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            dfs(students, mentors, index + 1, isVisited, sum + getScore(students[i], mentors[index]));
            isVisited[i] = false;
        }
    }

    private int getScore(int[] student, int[] mentor) {
        int score = 0;
        for (int i = 0; i < student.length; i++) {
            score += (student[i] == mentor[i] ? 1 : 0);
        }
        return score;
    }

}
