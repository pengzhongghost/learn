package leetcode题目.java基础;

public class Excel表列序号 {
    /**
     * https://leetcode-cn.com/problems/excel-sheet-column-number/
     * Excel表列序号
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
     * 例如：
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * <p>
     * 示例 1:
     * 输入: columnTitle = "A"
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入: columnTitle = "AB"
     * 输出: 28
     * <p>
     * 示例 3:
     * 输入: columnTitle = "ZY"
     * 输出: 701
     */
    public static void main(String[] args) {
        String columnTitle = "AB";
        columnTitle = "ZY";
        System.out.println(titleToNumber(columnTitle));
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
