package 位运算;

public class BitOperate {
    /**
     * 1、m进制数num转为10进制
     * 从低位到高位按权展开即可。
     * 例如：8进制1356 转为10进制
     * 6*8^0 + 5 * 8^1 + 3 * 8^2 + 1 * 8^3 = 750
     * 十六进制转十进制
     * 0x23A   10*16^0+3*16^1+2*16^2=10+48+512=570
     * <p>
     * 2、10进制转为n进制
     */
    public static void main(String[] args) {
        //原码 反码 补码
        /**
         * 1.二进制的最高位是符号位，0表示正数，1表示负数
         * 2.正数的原码，反码，补码都一样
         * 3.负数的反码=它的原码符号位不变，其他位取反(0->1,1->0)
         * 4.负数的补码=它的反码+1，负数的反码=负数的补码-1
         * 5.0的反码，补码都是0
         * 6。java没有无符号数，换言之，Java中的数都是有符号的
         * 7。在计算机运算的时候，都是以补码的方式来运算的
         * 8。当我们看运算结果的时候，要看它的原码
         */
        //按位与& 都是1则为1，否则都是0
        //先得到2的原码 00000000 00000000 00000000 00000010
        //2的补码 00000000 00000000 00000000 00000010(正数三码合一)
        //3的补码 00000000 00000000 00000000 00000011
        //按位与运算后的补码 00000000 00000000 00000000 00000010
        System.out.println(2 & 3);
        //按位取反 0->1,1->0
        //-2的原码 10000000 00000000 00000000 00000010
        //-2的反码 11111111 11111111 11111111 11111101(负数的补码是反码+1)
        //-2的补码 11111111 11111111 11111111 11111110(反码+1)
        //按位取反 00000000 00000000 00000000 00000001(反码+1)
        System.out.println(~-2);
        //按位 | 两位有一个1，结果为1，否则为0
        //按为异或 ^ 两位一个为0，一个为1，则结果为1，否则为0

        //算术右移
        //1   00000000 00000000 00000000 00000001
        //低位溢出，符号位不变，并用符号位补溢出的高位
        //1   00000000 00000000 00000000 00000000
        //相当于/2/2
        int a = 1 >> 2;
        //算术左移
        //1   00000000 00000000 00000000 00000001
        //符号位不变,低位左移补0
        //1   00000000 00000000 00000000 00000100
        //相当与*2*2
        int b = 1 << 2;
        //逻辑右移,低位溢出，高位补0
        int c = -8 >>> 2;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }


}
