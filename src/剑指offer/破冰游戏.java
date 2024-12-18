package 剑指offer;

public class 破冰游戏 {

    //(当前index + target) % 上一轮剩余数字的个数
    /**
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/description/
     *
     * 假设我们最好剩余的数字是N。
     * 执行完“删除第三个元素”的操作后，N在新数组中的位置P的意义是什么？ ——它表示，在新数组中，N前面有还有P个元素。那么，在当前数组中，N前面一定有“P+3”个元素。 明白了这一点即可开始倒推。
     * 最后一轮：当前有1个元素。N的位置是0；
     * 倒数第2轮：当前有2个元素。已知在执行完“删除第三个元素”后，N在新数组中的位置是0。则说明在本轮中N前面有0+3=3个元素，所以N的位置是3，然而本轮只有2个元素，所以N的实际位置是（0+3）%2=1；
     * 倒数第3轮：当前有3个元素。已知在执行完“删除第三个元素”后，N’在新数组中的位置是1。说明此刻，N前面有1+3=4个元素，所以N的位置是4。而当前数组只有3个元素，故实际位置是（1+3）%3=1；
     */
    public int iceBreakingGame(int num, int target) {
        int index = 0;
        for(int i = 2; i<= num; i++) {
            index = (index + target) % i;
        }
        return index;
    }

}
