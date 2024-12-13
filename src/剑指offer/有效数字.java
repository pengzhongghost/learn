package 剑指offer;

public class 有效数字 {

    public static void main(String[] args) {
        boolean result = validNumber("2e0");
        System.out.println(result);
    }

    public static boolean validNumber(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        boolean signFlag = false;
        boolean dotFlag = false;
        boolean numFlag = false;
        boolean eFlag = false;
        for(int i = start; i <= end; i++) {
            if(isDigit(s.charAt(i))) {
                numFlag = true;
            } else if('.' == s.charAt(i) && !dotFlag && !eFlag) {
                dotFlag = true;
            } else if(('e' == s.charAt(i) || 'E' == s.charAt(i)) && numFlag && !eFlag) {
                eFlag = true;
                numFlag = false;
            } else if(('+' == s.charAt(i) || '-' == s.charAt(i)) && (i == start || 'e' == s.charAt(i-1) || 'E' == s.charAt(i -1))) {
                signFlag = true;
            } else {
                return false;
            }
        }
        return numFlag;
    }

    private static boolean isDigit(char a) {
        return a >= '0' && a <= '9';
    }

}
