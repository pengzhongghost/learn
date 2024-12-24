package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 模糊坐标 {

    /**
     * https://leetcode.cn/problems/ambiguous-coordinates/description/?envType=problem-list-v2&envId=backtracking
     */
    List<String> result = new ArrayList();

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            List<String> leftNums = getNums(s.substring(0, i));
            List<String> rightNums = getNums(s.substring(i));
            for (String leftNum : leftNums) {
                for (String rightNum : rightNums) {
                    result.add("(" + leftNum + ", " + rightNum + ")");
                }
            }
        }
        return result;
    }

    private List<String> getNums(String s) {
        List<String> nums = new ArrayList();
        if (1 == s.length() || !s.startsWith("0")) {
            nums.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String a = s.substring(0, i);
            String b = s.substring(i);
            if ((a.length() == 1 || !a.startsWith("0")) && b.charAt(b.length() - 1) != '0') {
                nums.add(a + '.' + b);
            }
        }
        return nums;
    }

}
