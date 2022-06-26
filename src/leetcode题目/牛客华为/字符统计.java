package leetcode题目.牛客华为;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 字符统计 {

    /**
     * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，
     * 如果统计的个数相同，则按照ASCII码由小到大排序输出。
     * 数据范围：字符串长度满足 1≤len(str)≤1000
     * <p>
     * 输入描述：
     * 一个只包含小写英文字母和数字的字符串。
     * 输出描述：
     * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
     * <p>
     * 示例1
     * 输入：
     * aaddccdc
     * 复制
     * 输出：
     * cda
     * 复制
     * 说明：
     * 样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }
        while (maxCount > 0) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (maxCount == entry.getValue()) {
                    System.out.print(entry.getKey());
                }
            }
            maxCount--;
        }

    }

}
