package leetcode题目.牛客华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 从单向链表中删除指定值的节点 {

    /**
     * https://www.nowcoder.com/practice/f96cd47e812842269058d483a11ced4f?tpId=37&tqId=21271&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int headNum = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(headNum);
        for (int i = 0; i < size - 1; i++) {
            int nextNum = sc.nextInt();
            int preNum = sc.nextInt();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == preNum) {
                    list.add(j + 1, nextNum);
                }
            }
        }
        list.remove((Object) sc.nextInt());
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

}
