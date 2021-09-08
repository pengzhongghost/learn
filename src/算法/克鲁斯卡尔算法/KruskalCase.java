package 算法.克鲁斯卡尔算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalCase {
    //顶点数组
    private char[] vertex;
    //邻接矩阵
    private int[][] matrix;
    //使用INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public KruskalCase(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //打印邻接矩阵
    public void print() {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //对边进行排序处理
    public void sortEdges(List<Edata> edges) {
        Edata temp;
        for (int i = 0; i < edges.size() - 1; i++) {
            for (int j = 0; j < edges.size() - 1 - i; j++) {
                if (edges.get(j).weight > edges.get(j + 1).weight) {
                    temp = edges.get(j);
                    edges.set(j, edges.get(j + 1));
                    edges.set(j + 1, temp);
                }
            }
        }
    }

    //返回顶点下标
    private int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (ch == vertex[i]) {
                return i;
            }
        }
        return -1;
    }

    //获取图中所有的边
    public List<Edata> getEdges() {
        List<Edata> edges = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != INF) {
                    edges.add(new Edata(vertex[i], vertex[j], matrix[i][j]));
                }
            }
        }
        return edges;
    }

    //获取下标为i的顶点的终点
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }


    public void kruskal() {
        //表示最后结果数组的索引
        int index = 0;
        //获取到边的集合并排序
        List<Edata> edges = getEdges();
        sortEdges(edges);
        //用于保存最小生成树的终点
        int[] ends = new int[edges.size()];
        //创建结果数组
        List<Edata> results = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            //获取边的第一个顶点
            int start = getPosition(edges.get(i).start);
            int end = getPosition(edges.get(i).end);
            //获取这个顶点的终点
            int m = getEnd(ends, start);
            int n = getEnd(ends, end);
            //是否构成回路
            if (m != n) {
                ends[m] = n;
                results.add(edges.get(i));
            }
        }
        for (Edata result : results) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},
        };
        KruskalCase kruskalCase = new KruskalCase(vertex, matrix);
        kruskalCase.kruskal();
    }

}

//边的类
class Edata {
    //边的起点
    char start;
    //边的终点
    char end;
    //边的权值
    int weight;

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edata{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

}