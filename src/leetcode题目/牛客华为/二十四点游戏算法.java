package leetcode题目.牛客华为;

import java.util.Scanner;

public class 二十四点游戏算法 {

    //https://www.nowcoder.com/practice/fbc417f314f745b1978fc751a54ac8cb?tpId=37&tqId=21290&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
    static boolean[] isVisited = new boolean[4];
    static int[] arr = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        for (int i = 0; i < 4; i++) {
            arr[index++] = sc.nextInt();
        }
        System.out.println(dfs(0, 0));
    }

    public static boolean dfs(int num, float sum) {
        if (num == 4 && sum == 24) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (dfs(num + 1, sum + arr[i])
                        || dfs(num + 1, sum - arr[i])
                        || dfs(num + 1, sum * arr[i])
                        || dfs(num + 1, sum / arr[i])) {
                    return true;
                }
                isVisited[i] = false;
            }
        }
        return false;
    }

}
