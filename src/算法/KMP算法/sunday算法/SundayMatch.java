package 算法.KMP算法.sunday算法;


public class SundayMatch {
    public static void main(String[] args) {
        String text = "龟龟子 绝绝 你好 绝绝子";
        String pattern = "你好子";
        boolean index = sunday(text, pattern);
        System.out.println(index);
    }

    private static Boolean sunday(String text, String pattern) {
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            } else {
                if (i + pattern.length() < text.length()) {
//这里必须从右向左匹配
                    int loc = pattern.lastIndexOf(text.charAt(i + pattern.length()));
                    i = i + pattern.length() - loc;
                    j = 0;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


//    public static int sundayMatch(String text, String pattern) {
//        if (text.length() < pattern.length()) {
//            return -1;
//        }
//        int i = 0;
//        int j = 0;
//        Map<Character, Integer> matchMap = getMatchIndexMap(pattern);
//        while (i < text.length()) {
//            if (text.charAt(i) == pattern.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                char achar = text.charAt(pattern.length() - j + i);
//                i = i - j + pattern.length() - matchMap.getOrDefault(achar, -1);
//                j = 0;
//            }
//            if (i == pattern.length()) {
//                return i - j;
//            }
//        }
//        return -1;
//    }


//    public static Map<Character, Integer> getMatchIndexMap(String pattern) {
//        int j = 0;
//        Map<Character, Integer> matchMap = new HashMap<>();
//        while (j < pattern.length() - 1) {
//            int temp = j;
//            matchMap.compute(pattern.charAt(j++), (k, v) -> temp);
//        }
//        return matchMap;
//    }
}
