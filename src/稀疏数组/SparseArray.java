package 稀疏数组;

public class SparseArray {

    /**
     * 创建一个原始的二维数组，11*11
     * 0：表示没有棋子，1表示黑子，2表示白子
     * @param args
     */
    public static void main(String[] args) {
        int[][] simpleArr = new int[11][11];
        simpleArr[1][2]=1;
        simpleArr[2][4]=2;
        //输出普通的二维数组
        for (int[] ints : simpleArr) {
            for (int data : ints) {
                System.out.printf(data+" ");
            }
            System.out.println();
        }
        /**
         * 将二维数组转稀疏数组
         */
        //计算稀疏数组的行数
        int num=0;
        for (int i = 0; i < simpleArr.length; i++) {
            for (int j = 0; j < simpleArr[i].length; j++) {
                if (simpleArr[i][j]>0){
                    num++;
                }
            }
        }
        int[][] sparsArr = new int[num + 1][3];
        sparsArr[0][0]= 11;
        sparsArr[0][1]= 11;
        sparsArr[0][2]= num;
        int count=0;
        for (int i = 0; i < simpleArr.length; i++) {
            for (int j = 0; j < simpleArr[i].length; j++) {
                if (simpleArr[i][j]>0){
                    count++;
                    sparsArr[count][0]=i;
                    sparsArr[count][1]=j;
                    sparsArr[count][2]=simpleArr[i][j];
                }
            }
        }
        //输出稀疏数组
        for (int[] ints : sparsArr) {
            for (int data : ints) {
                System.out.printf(data+" ");
            }
            System.out.println();
        }
        /**
         * 将稀疏数组转换为原始的二维数组
         */
        int[][] simpleArray=new int[sparsArr[0][0]][sparsArr[0][1]];
        for (int i = 1; i < sparsArr.length; i++) {
            simpleArray[sparsArr[i][0]][sparsArr[i][1]]=sparsArr[i][2];
        }
        for (int[] ints : simpleArray) {
            for (int data : ints) {
                System.out.printf(data+" ");
            }
            System.out.println();
        }
    }

}
