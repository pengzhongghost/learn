package leetcode题目.牛客华为;

import java.util.Scanner;

public class 名字的漂亮度 {

    /**
     * https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3?tpId=37&tqId=21268&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        while(sc.hasNextLine()){
            getScore(sc.nextLine());
        }
    }

    public static void getScore(String word){
        if (null==word||"".equals(word)){
            return;
        }
        int[] ant = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ant[word.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        for (int i = 0; i < ant.length; i++) {
            maxCount = Math.max(maxCount, ant[i]);
        }
        int score = 26, result = 0;
        while (maxCount > 0) {
            for (int i = 0; i < ant.length; i++) {
                if (maxCount == ant[i]) {
                    result += score * maxCount;
                    score--;
                }
            }
            maxCount--;
        }
        System.out.println(result);
    }

}
