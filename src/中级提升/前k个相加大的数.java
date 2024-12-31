package 中级提升;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 前k个相加大的数 {

    /**
     * 给定两个有序数组arr1和arr2，再给定一个整数k，
     * 返回来自arr1和arr2的两个数相加和最大的前k个，两个数必须分别来自两个数组。
     * 【举例】
     * arr1=[1.2.3.4,5]，arr2=[3,5,7.9,11]，k=4。返回数组[16,15.14.13]
     * 【要求】时间复杂度达到0(klogk)
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{3, 5, 7, 9, 11};
        int[] result = getMax(arr1, arr2, 4);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getMax(int[] arr1, int[] arr2, int k) {
        int[] result = new int[k];
        int index = 0;
        boolean[][] isVisited = new boolean[arr1.length][arr2.length];
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(arr1.length - 1, arr2.length - 1, arr1[arr1.length - 1] + arr2[arr2.length - 1]));
        isVisited[arr1.length - 1][arr2.length - 1] = true;
        while (index != k) {
            Node node = nodes.poll();
            result[index++] = node.sum;
            if (node.index01 > 0 && !isVisited[node.index01 - 1][node.index02]) {
                isVisited[node.index01 - 1][node.index02] = true;
                nodes.add(new Node(node.index01 - 1, node.index02, arr1[node.index01 - 1] + arr2[node.index02]));
            }
            if (node.index02 > 0 && isVisited[node.index01][node.index02 - 1]) {
                isVisited[node.index01][node.index02 - 1] = true;
                nodes.add(new Node(node.index01, node.index02 - 1, arr1[node.index01] + arr2[node.index02 - 1]));
            }
        }
        return result;
    }

    static class Node implements Comparable<Node> {

        private int index01;

        private int index02;

        private int sum;

        public Node(int index01, int index02, int sum) {
            this.index01 = index01;
            this.index02 = index02;
            this.sum = sum;
        }


        @Override
        public int compareTo(Node o) {
            return this.sum = o.sum;
        }
    }

}
