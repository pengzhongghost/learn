package 中级提升;

import java.util.HashMap;
import java.util.Map;

public class 穿过一条直线 {

    /**
     * 给定两个数组arrx和arry，长度都为N。
     * 代表二维平面上有N个点，第i个点的x坐标和y坐标分别为arrx[i]和arry[i]，
     * 返回求一条直线最多能穿过多少个点?
     */
    public static void main(String[] args) {
        System.out.println((double) 100000 / (double) 100001);
    }

    public static class Node {
        public int x;
        public int y;
    }

    public static int maxPoints(Node[] nodes) {
        int result = 0;
        //斜率表
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            map.clear();
            //斜率为y的差/x的差
            int samePosition = 1;//斜率相同
            int sameX = 0; //x坐标相同，斜率为无穷
            int sameY = 0; //y坐标相同，斜率为0
            int line = 0;
            for (int j = i + 1; j < nodes.length; j++) {
                int x = nodes[j].x - nodes[i].x;
                int y = nodes[j].y - nodes[i].y;
                if (x == 0 && y == 0) {
                    samePosition++;
                } else if (x == 0) {
                    sameX++;
                } else if (y == 0) {
                    sameY++;
                } else {
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    if (!map.containsKey(x)) {
                        map.put(x, new HashMap<>());
                    }
                    if (!map.get(x).containsKey(y)) {
                        map.get(x).put(y, 0);
                    }
                    map.get(x).put(y, map.get(x).get(y) + 1);
                    line = Math.max(line, map.get(x).get(y));
                }
                result = Math.max(result, Math.max(line, Math.max(sameX, sameY)) + samePosition);
            }
        }
        return 0;
    }

    /**
     * 利用辗转相除法——求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
