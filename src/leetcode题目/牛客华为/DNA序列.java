package leetcode题目.牛客华为;

import java.util.Scanner;

public class DNA序列 {

    /**
     * https://www.nowcoder.com/practice/e8480ed7501640709354db1cc4ffd42a?tpId=37&tqId=21286&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = sc.nextInt();
        int index = 0;
        int maxGC = 0;
        for (int i = 0; i < s.length() - len; i++) {
            int currentGC = 0;
            for (int j = i; j < len + i; j++) {
                if (s.charAt(j) == 'G' || s.charAt(j) == 'C') {
                    currentGC++;
                    if (currentGC > maxGC) {
                        index = i;
                        maxGC = currentGC;
                    }
                }
            }
        }
        System.out.println(s.substring(index, index + len));
    }

}
