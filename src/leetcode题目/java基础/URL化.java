package leetcode题目.java基础;

public class URL化 {
    /**
     * URL化
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。
     * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * <p>
     * 示例 1：
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * <p>
     * 示例 2：
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     */
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int length = 13;
        System.out.println(replaceSpaces(s, length));
    }

    public static String replaceSpaces(String s, int length) {
        return s.substring(0, length).replace(" ", "%20");
    }
}
