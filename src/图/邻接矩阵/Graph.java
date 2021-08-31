package 图.邻接矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    public static void main(String[] args) {
        int n = 5;
        String vertexValue[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        //添加顶点
        for (String s : vertexValue) {
            graph.insertVertex(s);
        }
        //添加边
        //A-B A-C
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();

        //深度遍历
        graph.dfs();

    }

    //存储顶点集合
    private List<String> vertexList;
    //存储对应点邻接矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;
    //记录某个节点是否被访问
    private boolean[] isVisited;

    //初始化
    public Graph(int n) {
        edges = new int[n][n];
        isVisited = new boolean[n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
    }

    //深度优先遍历算法
    //i 第一次就是0
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将该节点设置为已经访问
        isVisited[i] = true;
        //得到第一个邻接节点的下标
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }else {
                //如果已经被访问了
                w = getNextNeighbour(i, w);
            }
        }

    }

    //遍历所有的节点
    public void dfs() {
        for (int i = 0; i < getVertexNum(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbour(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //得到第一个邻接节点的下标,如果存在就返回对应的下标，否则就返回-1
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //获取顶点点个数
    public int getVertexNum() {
        return vertexList.size();
    }

    //获取边的数量
    public int getEdgeNums() {
        return numOfEdges;
    }

    //获取下表i的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //获取权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

}
