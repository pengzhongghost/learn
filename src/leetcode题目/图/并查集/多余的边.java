package leetcode题目.图.并查集;

import java.util.Arrays;

public class 多余的边 {
    /**
     * https://leetcode-cn.com/problems/7LpjUW/
     * 多余的边
     * 树可以看成是一个连通且 无环 的 无向 图。
     * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，
     * 且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi]
     * 表示图中在 ai 和 bi 之间存在一条边。请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。
     * 如果有多个答案，则返回数组 edges 中最后出现的边。
     * <p>
     * 示例 1：
     * 输入: edges = [[1,2],[1,3],[2,3]]
     * 输出: [2,3]
     */
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        int[] res = findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length + 1; i++) {
            if (unionFind.connected(edges[i][0], edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            } else {
                unionFind.union(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    //todo 并查集模板 https://leetcode-cn.com/problems/redundant-connection
    // /solution/zui-rong-yi-li-jie-de-bing-cha-ji-xiang-abg0f/
    static class UnionFind {
        private int count; //记录连通分量
        private int[] parent; //节点x的根节点是parent[x]

        public UnionFind(int n) {
            //一开始互不相通
            this.count = n;
            //一开始，每个节点是自己的父节点
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /*
        将p和q连接, 如果两个节点被连通，那么则让其中的一个根节点连接到另一个节点的根节点上
        */
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            //将两颗树合并为一颗
            parent[rootP] = rootQ; //parent[rootQ]=rootP 效果是一样的
            count--; //两个分量合二为一
        }

        //返回某个节点x的根节点
        private int find(int x) {
            //根节点的parent[x]==x
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        /*
         判断p和q是否连通:如果两个节点是连通的，那么他们一定拥有相同的根节点
         */
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        /*
        返回具体有多少个连通分量
         */
        public int count() {
            return count;
        }
    }
}
