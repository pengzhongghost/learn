package 算法.骑士周游问题;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//马踏棋盘问题
public class HorseChessBoard {
    //表示棋盘的列数
    private final static int X = 8;
    //表示棋盘的行数
    private final static int Y = 8;
    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    //使用一个属性，标记是否棋盘的所有位置都被访问了
    public static boolean finished;

    public static void main(String[] args) {
        visited = new boolean[X * Y];
        //棋盘
        int[][] chessBoard = new int[X][Y];
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, 0, 0, 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 完成骑士周游问题的算法
     *
     * @param chessBoard 棋盘
     * @param row        马儿当前位置的行
     * @param column     马儿当前位置的列
     * @param step       马儿走的第几步
     */
    public static void traversalChessBoard(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        //visited是一个一维数组存储的棋盘的64个位置
        visited[row * X + column] = true;
        //获取下一个可以走的位置的集合,x是列,y是行
        List<Point> nextList = next(new Point(column, row));
        /**
         * 排序,尽量使用下一个point能走的最少的进行处理
         */
        //对所有point对下一个对数目进行非递减排序
        sort(nextList);
        while (!nextList.isEmpty()) {
            //取出一个可以走的位置
            Point point = nextList.remove(0);
            //没有访问过
            if (!visited[point.y * X + point.x]) {
                traversalChessBoard(chessBoard, point.y, point.x, ++step);
            }
        }
        //定义一个finished是为了让代码结束
        if (step < X * Y && !finished) {
            chessBoard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    //根据当前的位置，计算马儿还能走哪些位置
    public static List<Point> next(Point curPoint) {
        List<Point> points = new ArrayList<>();
        Point p1 = new Point();
        //向左移动两列，向下移动一行
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            points.add(new Point(p1));
        }
        return points;
    }

    //对point对下一个对位置最少对进行排序
    public static void sort(List<Point> points) {
        //调用此方法10ms
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
        //调用此方法140ms
        //points.sort(Comparator.comparingInt(o->next(o).size()));
    }

}
