
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.check(0);
        System.out.println(checkCount);
        System.out.println(judge);
    }

    int[] arr = new int[8];

    static int checkCount = 0;

    static int judge = 0;

    public void check(int n) {
        if (n == 8) {
            checkCount++;
            list();
            return;
        }
        for (int i = 0; i < 8; i++) {
            arr[n] = i;
            if (isOk(n)) {
                check(n + 1);
            }
        }
    }

    public boolean isOk(int n) {
        judge++;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }

    public void list() {
        for (int i : arr) {
            System.out.printf(i + "\t");
        }
        System.out.println();
    }


}