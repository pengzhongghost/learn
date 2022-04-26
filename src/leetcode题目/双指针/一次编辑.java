package leetcode题目.双指针;

public class 一次编辑 {
    /**
     * 一次编辑
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
     * 编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * <p>
     * 示例 1:
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     */
    public static void main(String[] args) {
        String first = "pale";
        String second = "ple";
        System.out.println(oneEditAway(first, second));
    }

    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;
        int i = 0, j = 0, t = 0;
        while (i < first.length() && j < second.length()) {
            //todo 只要有两次i和j下标的元素不同，就是false
            if (first.charAt(i) != second.charAt(j)) {
                if (t > 0) {
                    return false;
                }
                //todo pale ple   'a'!='l'后一个的指针往前移一位，后面再同时+1
                if (first.length() > second.length()) {
                    j--;
                } else if (first.length() < second.length()) {
                    i--;
                }
                t++;
            }
            i++;
            j++;
        }
        return true;
    }
}
