package leetcode题目.图.bfs;

import java.util.*;

public class 开密码锁 {
    /**
     * https://leetcode-cn.com/problems/zlDJc7/
     * 开密码锁
     * 一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
     * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。列表 deadends 包含了一组死亡数字，
     * 一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
     * <p>
     * 示例 1:
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这个锁就会被锁定。
     */
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends, "0202"));
    }

    public static int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        //todo 死亡数字
        Set<String> dead = new HashSet<>();
        for (String str : deadends) {
            dead.add(str);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        int floor = 0;
        queue.offer("0000");
        dead.add("0000");
        while (!queue.isEmpty()) {
            floor++;
            //todo queue的size必须赋值给一个变量，这里会一直变化
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (String str : get(poll)) {
                    if (dead.contains(str)) {
                        continue;
                    }
                    if (str.equals(target)) {
                        return floor;
                    }
                    queue.offer(str);
                    //todo 此数字已经走过了则将之放入hashset中
                    dead.add(str);
                }
            }
        }
        return -1;
    }

    /**
     * 获取本次的数字所有可以变成的数字
     */
    public static List<String> get(String poll) {
        List<String> list = new ArrayList<>();
        char[] chars = poll.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char num = chars[i];
            chars[i] = numPrev(num);
            list.add(new String(chars));
            chars[i] = numNext(num);
            list.add(new String(chars));
            chars[i] = num;
        }
        return list;
    }

    public static char numPrev(char num) {
        return num == '0' ? '9' : (char) (num - 1);
    }

    public static char numNext(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }
}
