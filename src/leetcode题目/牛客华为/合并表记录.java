package leetcode题目.牛客华为;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 合并表记录 {

    /**
     * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，
     * 即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
     *
     * 提示:
     * 0 <= index <= 11111111
     * 1 <= value <= 100000
     * 输入描述：
     * 先输入键值对的个数n（1 <= n <= 500）
     * 接下来n行每行输入成对的index和value值，以空格隔开
     * 输出描述：
     * 输出合并后的键值对（多行）
     *
     * 示例1
     * 输入：
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 复制
     * 输出：
     * 0 3
     * 1 2
     * 3 4
     */
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}
