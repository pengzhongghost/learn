package 递归.迷宫回溯;

public class MiGong {
    public static void main(String[] args) {
        //8*7的迷宫
        int[][] map = new int[8][7];
        //使用1代表墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.printf(anInt+"\t");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("********************");
        //输出新的地图，小球走过并表示过的地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.printf(anInt+"\t");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归回溯来给小球找路
     * if小球到int[6][5]就是找到位置了
     * 当map[i][j]为1时为墙,2表示同路可以走，3表示该点已经走过了
     * 右->下->上->左
     *
     * @param map 表示地图
     * @param i   i，j表示小求的位置
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果i，j没有走过
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //map[i][j]!=0,可能是1，2，3
                return false;
            }
        }
    }


}
