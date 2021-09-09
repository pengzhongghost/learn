package leetcode题目.贪心;

public class 有效的回文 {

    /**
     * 判断是否是回文
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s=" ";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result.append(check(c) ? c : "");
        }
        if (result.toString().equals("")){
            return true;
        }
        return isBack(result.toString().toLowerCase(), 0,
                result.length() - 1)[0] > ((result.length() - 1) / 2);
    }

    public static boolean check(int i) {
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122) || (i >= 48 && i <= 57);
    }

    public static int[] isBack(String str, int l, int r) {
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                break;
            } else {
                l++;
                r--;
            }
        }
        return new int[]{l, r};
    }

}
