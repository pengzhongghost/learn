package 动态规划.从左往右尝试模型;

public class 八皇后 {

    public static void main(String[] args) {
        System.out.println(num1(8));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(num2(8));
    }

    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        return dfs(0, new int[n], n);
    }

    private static int dfs(int row, int[] record, int n) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) {
                record[row] = col;
                res += dfs(row + 1, record, n);
                record[row] = 0;
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            //不需要验证行，上面row+1就是不一样的行，只需要验证列
            if (col == record[i]
                    //验证行减去行和列减去列是否相对，也就是是否在对角线上面
                    || Math.abs(record[i] - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    //八皇后位运算版本
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        //只能放到多大
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return dfs02(limit, 0, 0, 0);
    }

    /**
     * @param limit       划定了问题的规模限制
     * @param colLim      列的限制，1的位置不能放皇后，0的位置可以
     * @param leftDiaLim  左斜线的限制，1的位置不能放皇后，0的位置可以
     * @param rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
     * @return
     */
    private static int dfs02(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        //所有的列都放满了皇后
        if (colLim == limit) {
            return 1;
        }
        //所有的候选皇后，都在pos上面
        //colLim | leftDiaLim | rightDiaLim 总限制
        //取反 就是为1的地方是我能够放皇后的位置，左侧的1需要去掉
        //取反之后和limit一与则取到右侧的能够放皇后的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));

        //最右侧的1
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            /**
             * 某个数取反再+1 再和原数相与 则可以获取到最右侧的1
             */
            //提取到最右侧的1来，剩下的位置都是0
            mostRightOne = pos & (~pos + 1);
            //每次都获取最右侧的1，再减去，再获取最右侧的1
            pos = pos - mostRightOne;

            res += dfs02(limit,
                    colLim | mostRightOne,
                    //左斜线要往左移
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);

        }
        return res;
    }

}
