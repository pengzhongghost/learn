package 算法.迪杰斯特拉算法;

import java.util.Arrays;

public class DijkstraAlgorithm {

    /**
     * 求的是G村庄到其他村庄到最短距离
     */
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //表示不可连接
        final int N = 65535;
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        //创建图
        Graph graph = new Graph(vertex, matrix);
        graph.dsj(6);
    }


}

//记录已经访问的集合
class VisitedVertex {
    //标记顶点是否被访问，1代表访问，0未访问
    public int[] alreadyArr;
    //每个下标对应的值为前一个顶点的下标
    public int[] preVisited;
    //记录出发顶点到其他顶点的距离
    public int[] dis;

    /**
     * @param length 表示顶点的个数
     * @param index  表示出发顶点的下标
     */
    public VisitedVertex(int length, int index) {
        this.alreadyArr = new int[length];
        this.preVisited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65535);
        //设置出发顶点已被访问
        alreadyArr[index] = 1;
        dis[index] = 0;
    }

    //判断index顶点是否被访问过
    public boolean isVisited(int index) {
        return alreadyArr[index] == 1;
    }

    //更新出发顶点到index这个顶点的距离
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    //更新pre顶点的前驱顶点为index的这个节点
    public void updatePre(int pre, int index) {
        preVisited[pre] = index;
    }

    //返回出发顶点到index这个顶点的距离
    public int getDis(int index) {
        return dis[index];
    }

    //找到下一个顶点
    public int getNextVertex() {
        int min = 65535, index = 0;
        //获取到真正的最小值的下一个顶点
        for (int i = 0; i < alreadyArr.length; i++) {
            if (alreadyArr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //同时更新此顶点被访问过
        alreadyArr[index] = 1;
        return index;
    }

}


//图
class Graph {
    //顶点数组
    private char[] vertex;
    //邻接矩阵
    private int[][] matrix;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void showGraph() {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //迪杰斯特拉算法,index为出发顶点对应的下标
    public void dsj(int index) {
        VisitedVertex visitedVertex = new VisitedVertex(vertex.length, index);
        update(index, visitedVertex);
        //选择下一个顶点
        for (int i = 1; i < vertex.length; i++) {
            //找到下一个顶点
            index = visitedVertex.getNextVertex();
            //更新此顶点
            update(index, visitedVertex);
        }
        int[] dis = visitedVertex.dis;
        for (int i = 0; i < dis.length; i++) {
            System.out.println(vertex[i] + "(" + dis[i] + ")");
        }
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
    private void update(int index, VisitedVertex visitedVertex) {
        int len;
        for (int i = 0; i < matrix.length; i++) {
            //len是出发顶点到index顶点的距离+从index顶点到i这个顶点的和
            len = visitedVertex.getDis(index) + matrix[index][i];
            //如果i顶点没有被访问过，并且len小于出发顶点到i的距离，就需要更新
            if (!visitedVertex.isVisited(i) && len < visitedVertex.getDis(i)) {
                //更新i的前驱节点
                visitedVertex.updatePre(i, index);
                //更新index到i的距离
                visitedVertex.updateDis(i, len);
            }
        }

    }

}