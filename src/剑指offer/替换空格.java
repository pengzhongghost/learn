package 剑指offer;

public class 替换空格 {

    /**
     * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
     * @param path
     * @return
     */
    public String pathEncryption(String path) {
        StringBuilder sb = new StringBuilder();
        char[] arr = path.toCharArray();
        for(char c : arr) {
            if('.' == c) {
                sb.append(' ');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
