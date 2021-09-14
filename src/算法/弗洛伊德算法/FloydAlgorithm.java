package 算法.弗洛伊德算法;

import java.util.Arrays;

public class FloydAlgorithm {
    /**
     * 求出各个村庄到其他村庄到最短路径
     */
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //表示不可连接
        final int N = 65535;
        int[][] matrix = {
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}
        };
        Graph graph = new Graph(vertex.length, vertex, matrix);
        graph.floyd();
        int[][] dis = graph.dis;
    }

}

class Graph {
    //存放顶点数组
    public char[] vertex;
    //从各个顶点出发到其他顶点到距离
    public int[][] dis;
    //保存到达目标顶点到前驱顶点
    public int[][] pre;

    public Graph(int length, char[] vertex, int[][] matirx) {
        this.vertex = vertex;
        this.dis = matirx;
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    //弗洛伊德算法
    public void floyd() {
        int len;
        //对中间顶点对遍历，k就是下标
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发,开始顶点
            for (int i = 0; i < dis.length; i++) {
                //结束顶点
                for (int j = 0; j < dis.length; j++) {
                    //求出从i到k再到j到距离
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        //更新距离
                        dis[i][j] = len;
                        //更新前驱节点
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }

}