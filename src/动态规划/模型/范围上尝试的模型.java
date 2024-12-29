package 动态规划.模型;

public class 范围上尝试的模型 {

    /**
     * 给定一个整型数组arr, 代表数值不同的纸牌排成一条线
     * 玩家A和玩家B依次拿走每张纸牌规定玩家A先拿，玩家B后拿，
     * 但是每个玩家每次只能拿走最左或最右的纸牌玩家
     * A和玩家B都绝顶聪明。请返回最后获胜者的分数。
     */
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5};
        int former = former(arr, 0, arr.length - 1);
        int latter = latter(arr, 0, arr.length - 1);
        int res = win1(arr);
        System.out.println(former);
        System.out.println(latter);
        System.out.println(res);
    }

    public static int win1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        return Math.max(
                //A先手获得的分数
                former(arr, 0, arr.length - 1),
                //B后手获得的分数
                latter(arr, 0, arr.length - 1));
    }

    /**
     * 先手拿牌
     */
    private static int former(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        return Math.max(arr[left] + latter(arr, left + 1, right),
                arr[right] + latter(arr, left, right - 1));
    }

    /**
     * 后手拿牌，只能拿到别人不要的分数，A选择的Math.max，则B只能选择小的
     */
    private static int latter(int[] arr, int left, int right) {
        //已经没牌拿了
        if (left == right) {
            return 0;
        }
        //此时B优先挑牌，所以调用former去了
        return Math.min(former(arr, left + 1, right),
                former(arr, left, right - 1));
    }

    /**
     * dp方式
     */
    public static int dpWay(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int[][] former = new int[arr.length][arr.length];
        int[][] latter = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            //left == right的情况
            former[i][i] = arr[i];
            latter[i][i] = 0;
        }
        //  \这样的对角线一个一个往右上角填充
        for (int i = 1; i < arr.length; i++) {
            int left = 0;
            int right = i;
            while (left < arr.length && right < arr.length) {
                former[left][right] = Math.max(
                        arr[left] + latter[left + 1][right],
                        arr[right] + latter[left][right - 1]);
                latter[left][right] = Math.min(
                        former[left + 1][right],
                        former[left][right + 1]
                );
                left++;
                right++;
            }
        }
        return Math.max(former[0][arr.length - 1], latter[0][arr.length - 1]);
    }


}
