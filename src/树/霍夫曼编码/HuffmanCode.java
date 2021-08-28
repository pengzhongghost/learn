package 树.霍夫曼编码;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] content = str.getBytes();
        //压缩
        byte[] huffmanCodesBytes = huffmanZip(content);
        //System.out.println(Arrays.toString(huffmanCodesBytes));
        //解压
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println(new String(sourceBytes));
    }


    //解压
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanCodesBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        //获取到字符串
        for (int i = 0; i < huffmanCodesBytes.length; i++) {
            byte aByte = huffmanCodesBytes[i];
            //如果是最后一个字节，无需补高位
            boolean flag = (i == huffmanCodesBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, aByte));
        }
        //把字符串按照指定的霍夫曼编码进行解码
        //反向霍夫曼编码
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //获取到所有的单个的字符
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            if (null != b) {
                list.add(b);
            }
            //i移动到count
            i += count;
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    //将一个byte转为二进制的字符串
    //flag表示是否需要补高位
    public static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        //如果是正数，需要补高位
        //最后一位可能不满8位
        if (flag) {
            temp |= 256;//按位或
        }
        //返回的temp对应的二进制的补码
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    /**
     * --------------------------分割线-------------------------------
     */

    //压缩
    public static byte[] huffmanZip(byte[] content) {
        List<Node> nodes = getNodes(content);
        //通过list创建一个霍夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        //huffmanTree.preOrder();
        //霍夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
        //System.out.println(huffmanCodes);
        //霍夫曼编码处理过后的字节数组
        return zip(content, huffmanCodes);
    }


    /**
     * @param bytes        原始的字符串数组
     * @param huffmanCodes 霍夫曼编码
     * @return 经过霍夫曼编码处理后的数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCodes.get(aByte));
        }
//        int length = stringBuilder.length() % 8 == 0 ? (stringBuilder.length() / 8)
//                : (stringBuilder.length() / 8 + 1);
        //压缩后的数组的长度
        int length = (stringBuilder.length() + 7) / 8;
        //创建压缩后的数组
        byte[] temp = new byte[length];
        int index = 0;
        //每8位对应一个
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //转成二进制
            temp[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return temp;
    }

    //生成霍夫曼树对应的霍夫曼编码表
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    //生成霍夫曼编码重载方法
    public static Map<Byte, String> getCodes(Node node) {
        if (null == node) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        getCodes(node.left, "0", stringBuilder);
        getCodes(node.right, "1", stringBuilder);
        return huffmanCodes;
    }


    /**
     * 生成霍夫曼编码
     *
     * @param node          根节点
     * @param code          路径：左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接路径
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (null != node) {
            //非叶子节点
            if (null == node.data) {
                //向左
                getCodes(node.left, "0", stringBuilder2);
                //向右
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
                return;
            }
        }
    }

    //把字符串遍历出来，将字符和字符数量放入list中
    public static List<Node> getNodes(byte[] content) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : content) {
            if (null == map.get(b)) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b) + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getValue(), entry.getKey()));
        }
        return nodes;
    }

    //通过list创建一个霍夫曼树
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

}


class Node implements Comparable<Node> {
    //权值
    public int weight;
    //存放数据本身
    public Byte data;
    public Node left;
    public Node right;

    public Node(int weight) {
        this.weight = weight;
    }

    public Node(int weight, Byte data) {
        this.weight = weight;
        this.data = data;
    }


    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (null != this.left) {
            this.left.preOrder();
        }
        if (null != this.right) {
            this.right.preOrder();
        }
    }

}