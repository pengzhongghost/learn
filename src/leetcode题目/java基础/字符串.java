package leetcode题目.java基础;

import sun.misc.Version;

public class 字符串 {
    /**
     * 字符串拼接操作：
     * 1.常量与常量拼接结果在常量池中
     * 2.常量池中不会存在相同内容的常量
     * 3.只要其中有一个是变量，结果就在堆中。变量拼接的原理是stringbuilder
     * 4.如果拼接的结果是调用的intern（）方法，则主动将常量池中还没有的字符串对象放入池中，并返回此对象地址。
     */
    public static void main(String[] args) {
        test04();
    }

    //todo 常量与常量拼接结果在常量池中
    public static void test01() {
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        //==比较的是地址
        System.out.println(s1 == s2);//true
        System.out.println(s1.equals(s2));//true
    }

    //todo 只要其中有一个是变量，结果就在堆中,相当于new对象
    public static void test02() {
        String s1 = "a" + "b";
        String s3 = "c";
        String s4 = s1 + s3;
        String s2 = "abc";
        //==比较的是地址
        System.out.println(s1 + s3 == s2);//false
        System.out.println((s1 + s3).equals(s2));//true
        System.out.println(s2 == s4);//false
        //todo intern():判断字符串常量池中是否存在abc值，如果存在，则返回常量池中abc的地址，
        //     如果字符串常量池中不存在abc，则在常量池中加载一份abc，并返回此对象的地址。
        System.out.println(s2 == s4.intern());//true
    }

    //TODO new String("1")创建了几个对象
    // new string常量池中的地址和堆中的地址不同
    public static void test03() {
        //todo 堆空间中有一个对象，常量池中有个1
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);//jdk1.6 false jdk1.7/8 false
        //todo new String("1") + new String("1")
        //      5个对象
        // new StringBuilder()
        // new String("a")  常量池中的a
        // new String("b")  常量池中的b
        // 深入剖析： StringBuilder的toString方法
        //      对象6：new String（"ab"）没有在常量池中生成对象
        String s3 = new String("a") + new String("b");
        //执行完上一行代码以后，字符串常量池中，不存在ab
        s3.intern();//在字符串常量池中生成ab,jdk6中创建了一个新的对象，也就有新的地址
        String s4 = "ab";//使用的是上一行代码中生成的常量池中的ab的地址
        System.out.println(s3 == s4);//jdk1.6 false jdk1.7/8 true
    }

    public static void test04() {
        String str01 = new StringBuilder().append("58").append("tongcheng").toString();
        System.out.println(str01);
        System.out.println(str01.intern());
        System.out.println(str01 == str01.intern());//true
        System.out.println();
        //todo sun.misc.Version中自带了一个java，类加载的时候字符串常量池中就已经有了一个Java
        String str02 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str02);
        System.out.println(str02.intern());
        System.out.println(str02 == str02.intern());//false
    }

}
