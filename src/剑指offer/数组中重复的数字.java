package 剑指offer;

import java.util.Arrays;

public class 数组中重复的数字 {

    /**
     * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/description/
     * @param documents
     * @return
     */
    public int findRepeatDocument(int[] documents) {
        Arrays.sort(documents);
        for(int i = 0; i < documents.length-1; i++){
            if(documents[i] == documents[i+1]){
                return documents[i];
            }
        }
        return -1;
    }

}
