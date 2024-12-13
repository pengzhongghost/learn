package 剑指offer;

public class 砍竹子 {

    /**
     * https://leetcode.cn/problems/jian-sheng-zi-lcof/description/
     */
    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len < 4) {
            return bamboo_len - 1;
        }
        long res = 1;
        while (bamboo_len > 4) {
            //本来应该是考虑到4的情况2*2更加大，1*3更加小，
            //但是这里bamboo_len > 4，所以不需要考虑
            res = res * 3 % 1000000007;
            bamboo_len -= 3;
        }
        return (int) (res * bamboo_len % 1000000007);
    }

}
