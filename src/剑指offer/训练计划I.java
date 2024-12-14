package 剑指offer;

public class 训练计划I {

    /**
     * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/description/
     */

    public int[] trainingPlan(int[] actions) {
        int left = 0;
        int right = actions.length - 1;
        while(left < right) {
            if((actions[left] & 1) != 1 && (actions[right] & 1) != 0) {
                int temp = actions[left];
                actions[left] = actions[right];
                actions[right] = temp;
            } else if(actions[left] % 2 != 0) {
                left ++;
            } else{
                right --;
            }
        }
        return actions;
    }

}
