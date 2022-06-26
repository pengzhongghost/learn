package leetcode题目.牛客华为;

import java.util.Scanner;

public class 高精度整数加法 {

    /**
     * https://www.nowcoder.com/practice/49e772ab08994a96980f9618892e55b6?tpId=37&tqId=21280&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String preStr = sc.nextLine();
        String nextStr = sc.nextLine();

        int[] arr = new int[Math.max(preStr.length(), nextStr.length()) + 1];
        int beforeNum = 0, index = arr.length - 1, sum;
        for (int i = preStr.length() - 1, j = nextStr.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int preNum = i >= 0 ? preStr.charAt(i) - '0' : 0;
            int nextNum = j >= 0 ? nextStr.charAt(j) - '0' : 0;
            sum = beforeNum + preNum + nextNum;
            beforeNum = sum / 10;
            arr[index--] = sum % 10;
        }
        arr[index] = beforeNum;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[0] == 0) {
                continue;
            }
            result.append(arr[i]);
        }
        System.out.println(result);
    }

}
