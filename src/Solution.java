import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums, 0, new ArrayList<>());
        return res;
    }

    public void backTrace(int[] nums, int index, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; ++i) {
            //剔除重复元素
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backTrace(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}