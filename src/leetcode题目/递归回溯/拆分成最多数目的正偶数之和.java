package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 拆分成最多数目的正偶数之和 {

    public static void main(String[] args) {
        List<Long> result = maximumEvenSplit(8);
        System.out.println(result);
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }

}
