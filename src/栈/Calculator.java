package 栈;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Stack<Object> opers = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        String expression = "300+2*6-2";
        String keepNum = "";
//        for (char c : expression.toCharArray()) {
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //如果是运算符
            if (isOper(chars[i])) {
                if (!opers.isEmpty()) {
                    if (get(chars[i]) <= get((char) opers.peek())) {
                        int res = cal(nums.pop(), nums.pop(), (char) opers.pop());
                        //把计算结果入数栈，把符号入符号栈
                        nums.push(res);
                        opers.push(chars[i]);
                    } else {
                        opers.push(chars[i]);
                    }
                } else {
                    opers.push(chars[i]);
                }
            } else {
                //如果是数字，可能是多位数字
                keepNum += chars[i];
                //如果下一个字符还是数字，继续拼接,如果是符号，则入栈
                if (i < chars.length - 1) {
                    if (isOper(chars[i + 1])) {
                        nums.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                } else {
                    nums.push(Integer.parseInt(keepNum));
                }


            }
        }

//        }
        while (true) {
            //符号空的时候才是计算完毕，否则一直pop出来计算
            if (opers.isEmpty()) {
                break;
            }
            int res = cal(nums.pop(), nums.pop(), (char) opers.pop());
            //把计算结果入数栈，把符号入符号栈
            nums.push(res);
        }
        System.out.println(nums.pop());
        System.out.println("结束");
    }

    //返回运算符的优先级，数字越大优先级越高
    public static int get(int oper) {
        switch (oper) {
            case '*':
                return 1;
            case '/':
                return 1;
            case '+':
                return 0;
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    //判断是否是运算符
    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '/' | val == '*';
    }

    public static int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            default:
                return 0;
        }
    }

}
