package 剑指offer;

public class 二维数组中的查找 {

    /**
     * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/description/
     * @param plants
     * @param target
     * @return
     */
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int i = plants.length -1;
        int j = 0;
        while (i >= 0 && j <= plants[i].length-1) {
            if(target == plants[i][j]) {
                return true;
            }if(target > plants[i][j]) {
                j++;
            } else if(target < plants[i][j]) {
                i--;
            }
        }
        return false;
    }

}
