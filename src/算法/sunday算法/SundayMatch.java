package 算法.sunday算法;


public class SundayMatch {
    public static void main(String[] args) {
        String text = "前端交付提测:\n"
                + "  交付报告检查$22000046: delivery_report_check = true\n";
        String pattern = "前端测试用例检查";
        String text02 = "mississippi";
        String pattern02 = "sippia";
        boolean index = sunday(text02,pattern02);
        System.out.println(index);
    }

    public static boolean sunday(String sourse, String target) {
        char[] tempS = sourse.toCharArray();
        char[] tempT = target.toCharArray();

        int k = 0;
        int j = 0;
        return compare(tempS, tempT, k, j);
    }


    /**
     * 对比主过程(递归调用)
     *
     * @param tempS 源字符串
     * @param tempT 目标字符串
     * @param j     本次比较源字符串初始下标
     * @param k     同j
     * @return
     */
    public static boolean compare(char[] tempS, char[] tempT, int j, int k) {
        //System.out.println("比较开始下标：" + k + "  " + j);
        for (int i = j; i < j + tempT.length; i++) {
            if (tempT[i - j] == tempS[i]) {
                k++;
                continue;
            } else {
                break;
            }
        }
        //k-j代表本次比较的次数，如果和目标字符串的长度相等，则说明每个字符都对比成功，即在源字符串中找到了目标字符串
        if (k - j == tempT.length) {
            //System.out.println("匹配成功");
            return true;
        }
        k = j + tempT.length;
        if (k < (tempS.length - 1)) {
            int value = check(tempS[k], tempT);
            int step = -value;
            j = k + step;
            return compare(tempS, tempT, j, j);
        } else {
            return false;
        }
    }

    /**
     * 检查目标字符串tempT是否包含c
     *
     * @param c
     * @param tempT
     * @return
     */
    public static int check(char c, char[] tempT) {
        for (int i = tempT.length - 1; i >= -1; i--) {
            if (i == -1 || tempT[i] == c) {
                return i;
            } else {
                continue;
            }
        }
        return 0;
    }


}
