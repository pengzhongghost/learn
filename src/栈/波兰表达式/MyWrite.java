package 栈.波兰表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyWrite {
    public static void main(String[] args) {
        String str = "30+(2+1)*3-2";
        List<String> stringToList = stringToList(str);
        System.out.println(stringToList);
        List<String> result = getResult(stringToList);
        System.out.println(result);
        System.out.println(cal(result));
    }

    public static int cal(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                stack.push(getCal(Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()), s) + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List<String> getResult(List<String> list) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                s2.add(str);
            } else {
                if (str.equals("(")) {
                    s1.push(str);
                } else if (str.equals(")")) {
                    while (true) {
                        if ("(".equals(s1.peek())) {
                            s1.pop();
                            break;
                        }
                        s2.add(s1.pop());
                    }
                } else if (!s1.empty() && getGrade(str) <= getGrade(s1.peek())) {
                    s2.add(s1.pop());
                    s1.push(str);
                } else {
                    s1.push(str);
                }
            }
        }
        while (!s1.empty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int getCal(int num01, int num02, String str) {
        switch (str) {
            case "+":
                return num02 + num01;
            case "-":
                return num02 - num01;
            case "*":
                return num02 * num01;
            case "/":
                return num02 / num01;
            default:
                throw new RuntimeException("无此运算符：" + str);
        }
    }

    public static int getGrade(String str) {
        switch (str) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    public static List<String> stringToList(String str) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        if (null == chars || chars.length < 1) {
            return list;
        }
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar < 48 || aChar > 57) {
                list.add(aChar + "");
            } else {
                temp += aChar - 48;
                if (i < chars.length - 1) {
                    if (chars[i + 1] < 48 || chars[i + 1] > 57) {
                        list.add(temp);
                        temp = "";
                    }
                } else {
                    list.add(temp);
                    temp = "";
                }
            }
        }
        return list;
    }

}
