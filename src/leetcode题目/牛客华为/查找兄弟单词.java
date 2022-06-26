package leetcode题目.牛客华为;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 查找兄弟单词 {

    /**
     * https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68?tpId=37&tqId=21250&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = sc.next();
        }
        String temp = sc.next();
        int k = sc.nextInt();
        int count = 0;
        PriorityQueue<String> result = new PriorityQueue();
        for (String word : words) {
            if (!temp.equals(word) && isBrother(word, temp)) {
                result.add(word);
                count++;
            }
        }
        System.out.println(count);
        for (int i = 0; i < k - 1; i++) {
            result.poll();
        }
        if (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }

    public static boolean isBrother(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return new String(aChars).equals(new String(bChars));
    }


}
