package 算法.普里姆算法;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertx = data.length;
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGraph mGraph = new MGraph(vertx);
        MiniTree tree = new MiniTree();
        tree.createGraph(mGraph, data, weight);
        tree.showGraph(mGraph);
        tree.prim(mGraph, 0);
    }
}

//创建最小生成树->村庄的图
class MiniTree {
    /**
     * 创建图的邻接矩阵
     *
     * @param graph
     * @param data
     * @param weight
     */
    public void createGraph(MGraph graph, char[] data, int weight[][]) {
        graph.data = data;
        graph.weight = weight;
    }

    //输出邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    public void prim(MGraph graph, int v) {
        //已经访问过的,默认false
        boolean[] visited = new boolean[graph.vertx];
        //标记v为访问过的
        visited[v] = true;
        //h1,h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int miniWeight = 10000;
        //有n个顶点，就会生成n-1个边
        for (int i = 1; i < graph.vertx; i++) {
            //遍历访问过的节点
            for (int j = 0; j < graph.vertx; j++) {
                //遍历没有访问过的节点
                for (int k = 0; k < graph.vertx; k++) {
                    int weight = graph.weight[j][k];
                    if (visited[j] && !visited[k] && weight < miniWeight) {
                        //记录下真正最小的权值
                        miniWeight = weight;
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            System.out.println(graph.data[h1] + "," + graph.data[h2] + "边：" + graph.weight[h1][h2]);
            visited[h2] = true;
            miniWeight = 10000;
        }

    }

}

class MGraph {
    //表示图的节点个数
    int vertx;
    //存放节点数据
    char[] data;
    //存放边，就是我们的邻接矩阵
    int[][] weight;

    public MGraph(int vertx) {
        this.vertx = vertx;
        data = new char[vertx];
        weight = new int[vertx][vertx];
    }

}