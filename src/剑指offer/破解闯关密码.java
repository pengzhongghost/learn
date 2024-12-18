package 剑指offer;

import java.util.Arrays;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 破解闯关密码 {

    /**
     * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/description/
     */
    public String crackPassword(int[] password) {
        String[] arr = new String[password.length];
        for(int i = 0;i<arr.length;i++) {
            arr[i] = password[i] + "";
        }
        Arrays.sort(arr, (a, b) -> (a+b).compareTo(b+a));
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

}
