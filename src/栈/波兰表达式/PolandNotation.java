package 栈.波兰表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先定义给逆波兰表达式(后缀表达式)
        //(30+4)*5-6 => 30 4 + 5 * 6
        String suffixExpression = "30 4 + 5 * 6 - ";
        System.out.println(cal(suffixExpression));
        List<String> list = PolandNotation.parseMiddleToList("1+((2+3)*4)-5");
        System.out.println(list);
        List<String> polandList = PolandNotation.MiddleListToLastList(list);
        System.out.println(polandList);
        String poland = "";
        for (String s : polandList) {
            poland += s + " ";
        }
        System.out.println(poland);
        System.out.println(cal(poland));

    }

    /**
     * 后缀表达式计算
     *
     * @param suffixExpression
     * @return
     */
    public static int cal(String suffixExpression) {
        Stack<String> stack = new Stack<>();
        String[] split = suffixExpression.split(" ");
        for (String s : split) {
            if (s.matches("\\d++")) {
                stack.push(s);
            } else {
                int res = 0;
                Integer num01 = Integer.parseInt(stack.pop());
                Integer num02 = Integer.parseInt(stack.pop());
                if (s.equals("+")) {
                    res = num01 + num02;
                } else if (s.equals("-")) {
                    res = num02 - num01;
                } else if (s.equals("*")) {
                    res = num01 * num02;
                } else if (s.equals("/")) {
                    res = num02 / num01;
                } else {
                    throw new RuntimeException("不支持此运算符：" + s);
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] =>转 后缀表达式list
     */
    public static List<String> MiddleListToLastList(List<String> list) {
        //符号栈
        Stack<String> s1 = new Stack<>();
        //存储中间结果 即为最终的逆波兰表达式
        List<String> s2 = new ArrayList<>();
        for (String item : list) {
            //如果是一个数，则入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //将(弹出
                s1.pop();
            } else {
                //当item的优先级<=s1栈顶的优先级
                while (s1.size() != 0 && Operation.getValue(item) <= Operation.getValue(s1.peek())) {
                    s2.add(s1.pop());
                }
                //最后将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的加入到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }


    /**
     * 中缀表达式1+((2+3)*4)-5 => list
     */
    public static List<String> parseMiddleToList(String str) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        String num = "";
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //如果是非数字
            if (aChar < 48 || aChar > 57) {
                list.add(aChar + "");
            } else {
                //如果是数字
                num += aChar - 48 + "";
                if (i == chars.length - 1) {
                    list.add(num);
                    num = "";
                } else {
                    if (chars[i + 1] < 48 || chars[i + 1] > 57) {
                        list.add(num);
                        num = "";
                    }
                }
            }
        }
        return list;
    }

}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println();
        }
        return res;
    }

}