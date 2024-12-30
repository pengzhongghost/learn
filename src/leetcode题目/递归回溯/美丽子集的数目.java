package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/27
 */
public class 美丽子集的数目 {

    /**
     * https://leetcode.cn/problems/the-number-of-beautiful-subsets/?envType=problem-list-v2&envId=backtracking
     */

    static int result = -1;
    public static int beautifulSubsets(int[] nums, int k) {
        dfs(0, nums, k, new int[k * 2 + 1001]);
        return result;
    }

    private static void dfs(int index, int[] nums, int k, int[] isVisited){
        result++;
        if(index == nums.length) {
            return;
        }
        for(int i = index; i < nums.length; i++) {
            int num = nums[i] + k;
            if(0 == isVisited[num + k] && 0 == isVisited[num - k]) {
                isVisited[num]++;
                dfs(i + 1, nums, k, isVisited);
                isVisited[num]--;
            }
        }
    }

}
