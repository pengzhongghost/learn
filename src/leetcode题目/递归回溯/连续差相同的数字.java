package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 连续差相同的数字 {

    List<Integer> result = new ArrayList();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n - 1, k);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void dfs(int num, int n, int k) {
        if (0 == n) {
            result.add(num);
            return;
        }
        int cur = num % 10;
        int a1 = cur + k;
        int a2 = cur - k;
        if (a1 < 10) {
            dfs(num * 10 + a1, n - 1, k);
        }
        if (a2 >= 0 && a1 != a2) {
            dfs(num * 10 + a2, n - 1, k);
        }
    }

}
