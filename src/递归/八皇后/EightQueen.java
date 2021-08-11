package 递归.八皇后;

public class EightQueen {
    //八个皇后
    int max = 8;

    int arr[] = new int[max];

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
    }

    //编写一个方法放置第n个皇后
    public void check(int n) {
        //n是从0开始放的，=8的时候其实已经放好了
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            //如果不冲突，则开始放置第n+1个皇后
            if (judge(n)) {
                check(n + 1);
            }
            //如果冲突，则将第n个皇后放置则本行的后移1个位置（i+1）
        }

    }

    //查看放置第n个皇后的时候，就去检测该皇后是否和前面已经摆放的皇后冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //如果处于同一列或者同一条斜线上（等腰直角三角形）
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println();
    }


}
