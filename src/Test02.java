import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {

    public static void main(String[] args) {

    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] ant = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ant[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            ant[p.charAt(i) - 'a']--;
            if (check(ant)) {
                res.add();
            }
        }
    }

    public static void dfs(int[] ant,List<Integer> res){

    }

    private static boolean check(int[] ant) {

    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
