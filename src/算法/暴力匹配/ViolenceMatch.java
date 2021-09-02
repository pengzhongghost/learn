package 算法.暴力匹配;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1="龟龟子 绝绝 你好 绝绝子";
        String str2="绝绝子";
        int index = violenceMatch(str1, str2);
        System.out.println(index);
    }

    //暴力匹配
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //返回匹配前的下一个字符
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2.length) {
            return i - j;
        }
        return -1;
    }
}
