package 图.深度优先搜索;

import 图.邻接表.Graph;


class Test {
    public static void main(String[] args) {
        //准备一幅图
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        //深度优先搜索
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println(depthFirstSearch.count());
        System.out.println(depthFirstSearch.marked(5));
        System.out.println(depthFirstSearch.marked(7));


    }
}

public class DepthFirstSearch {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s顶点相通
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, s);
    }

    //使用深度优先算法找出G图中v顶点的所有相通顶点
    private void dfs(Graph G, int v) {
        //将v顶点标识为已经搜索
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            //判断当前w顶点有没有被搜索
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        //相通顶点数量+1
        count++;
    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    //获取与s顶点相通的所以顶点的总数
    public int count() {
        return count;
    }

}
