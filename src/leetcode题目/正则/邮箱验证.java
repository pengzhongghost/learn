package leetcode题目.正则;

public class 邮箱验证 {

    public static void main(String[] args) {
        //小写字母可以是1到6位，后面跟着可选的下划线_，
        //还可以跟着可选的1，4位的数字，最后面是必须跟着@hackerrank.com
        String regex = "^[a-z]{1,6}(|[_])(|[0-9]{1,4})@hackerrank.com$";
        System.out.println("oox9906@hackerrank.com".matches(regex));
        System.out.println("abcdef_123@hackerrank.com".matches(regex));
        System.out.println("abcdef_@hackerrank.com".matches(regex));
        System.out.println("abcdef123_@hackerrank.com".matches(regex));
        System.out.println("abcdef@hackerrank.com".matches(regex));
    }

}
