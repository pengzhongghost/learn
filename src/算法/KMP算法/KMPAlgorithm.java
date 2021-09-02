package 算法.KMP算法;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str01 = "BBC ABCDB ABCDABCDABDE";
        String str02 = "ABCDABD";
        //00101232
//        String test = "ABACABAB";
//        System.out.println(Arrays.toString(kmpNext(test)));
        int[] next = kmpNext(str02);
        System.out.println(Arrays.toString(next));
        int index = intkmpSearch(str01, str02, next);
        System.out.println(index);
    }

    //写出kmp搜索算法
    public static int intkmpSearch(String str01, String str02, int[] next) {
        for (int i = 0, j = 0; i < str01.length(); i++) {
            while (j > 0 && str01.charAt(i) != str02.charAt(j)) {
                j = next[j - 1];
            }
            if (str01.charAt(i) == str02.charAt(j)) {
                j++;
            }
            if (j == str02.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    //获取到一个字符串到部分匹配值
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        //如果dest的长度为1,部分匹配值是0
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //部分匹配值就需要+1
            //ABCDABD
            //0000120
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
