package 图.邻接表;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

//无向图
public class Graph {
    //顶点数目
    private int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        E = 0;
        adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedBlockingDeque<>();
        }
    }

    //获取顶点数目
    public int V() {
        return V;
    }

    //获取边的数目
    public int E() {
        return E;
    }

    //向图中添加一条边
    public void addEdge(int v, int w) {
        //无向图
        adj[v].add(w);
        adj[w].add(v);
        //边的数量+1
        E++;
    }

    //获取顶点v相邻的所以顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

}
