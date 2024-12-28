package 动态规划.模型;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 从左到右的尝试模型1 {


    public static void main(String[] args) {
        List<String> ams01 = new ArrayList<>();
        process1("abc", 0, ams01, "");
        System.out.println(ams01);
        Set<String> ams02 = new HashSet<>();
        process2("aac", 0, ams02, "");
        System.out.println(ams02);
        List<String> ams03 = new ArrayList<>();
        process3(new char[]{'a', 'b', 'c'}, 0, ams03);
        System.out.println(ams03);
        List<String> ams04 = new ArrayList<>();
        process4(new char[]{'a', 'a', 'a'}, 0, ams04, new boolean[26]);
        System.out.println(ams04);
    }

    /**
     * 打印一个字符串的全部子序列
     */
    public static void process1(String source, int index, List<String> ams, String path) {
        if (index == source.length()) {
            ams.add(path);
            return;
        }
        String no = path;
        process1(source, index + 1, ams, no);
        String yes = path + source.charAt(index);
        process1(source, index + 1, ams, yes);
    }

    /**
     * 打印一个字符串的全部子序列，要求不要出现重复字面值的子序列
     */
    public static void process2(String source, int index, Set<String> ams, String path) {
        if (index == source.length()) {
            ams.add(path);
            return;
        }
        String no = path;
        process2(source, index + 1, ams, no);
        String yes = path + source.charAt(index);
        process2(source, index + 1, ams, yes);
    }

    /**
     * 打印一个字符串的全部排列
     */
    public static void process3(char[] chars, int index, List<String> ams) {
        if (index == chars.length) {
            ams.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            process3(chars, i + 1, ams);
            swap(chars, index, i);
        }
    }

    /**
     * 打印一个字符串的全部排列(去重复版)
     */
    public static void process4(char[] chars, int index, List<String> ams, boolean[] isVisited) {
        if (index == chars.length) {
            ams.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (!isVisited[chars[i] - 'a']) {
                isVisited[chars[i] - 'a'] = true;
                swap(chars, index, i);
                process4(chars, i + 1, ams, isVisited);
                swap(chars, index, i);
                isVisited[chars[i] - 'a'] = false;
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
