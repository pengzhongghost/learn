package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 将数组拆分成斐波那契序列 {

    /**
     * https://leetcode.cn/problems/split-array-into-fibonacci-sequence/?envType=problem-list-v2&envId=backtracking
     */
    public static void main(String[] args) {
        List<Integer> result = splitIntoFibonacci("1101111");
        System.out.println(result);
    }

    static List<Integer> result = new ArrayList();
    public static List<Integer> splitIntoFibonacci(String num) {
        dfs(num, 0, 0, 0, result);
        return result;
    }

    private static void dfs(String num, int index, int pre, int preSum, List<Integer> temp) {
        if(index == num.length() && temp.size() >= 3) {
            result = new ArrayList<>(temp);
            return;
        }
        long curValue = 0;
        for(int i = index; i < num.length(); i++) {
            if(i > index && num.charAt(index) == '0') {
                break;
            }
            curValue = curValue * 10 + num.charAt(i) - '0';
            if(curValue > Integer.MAX_VALUE) {
                break;
            }
            int curVal = (int) curValue;
            if(temp.size() >= 2) {
                if(preSum > curVal) {
                    continue;
                } else if(preSum < curVal) {
                    break;
                }
            }
            temp.add(curVal);
            dfs(num, i + 1, curVal, curVal + pre, temp);
            temp.remove(temp.size() - 1);
        }
    }


}
