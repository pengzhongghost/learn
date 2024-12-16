package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 点名 {

    /**
     * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/
     */
    public int takeAttendance(int[] records) {
        if(records[0] == 1) {
            return 0;
        }
        for(int i =0; i< records.length;i++) {
            if(i != records[i]) {
                return i;
            }
        }
        return records.length;
    }

}
