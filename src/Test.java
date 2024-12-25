import java.util.*;

public class Test extends Base {

    public static void main(String[] args) {
        boolean b = new ArrayList<Integer>().stream().allMatch(integer -> 0 == integer);

        boolean result = makesquare(new int[]{1, 1, 2, 2, 2});
        System.out.println(result);
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(matchsticks, 0, 0, sum / 4);
    }

    private static boolean dfs(int[] matchsticks, int index, int count, int target) {
        if (4 == count) {
            return true;
        }
        if (0 == target) {
            count++;
        }
        for (int i = index; i < matchsticks.length; i++) {
            if (target - matchsticks[i] < 0) {
                continue;
            }
            if (dfs(matchsticks, i + 1, count, target - matchsticks[i])) {
                return true;
            }
        }
        return false;
    }

}