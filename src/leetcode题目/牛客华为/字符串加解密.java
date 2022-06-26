package leetcode题目.牛客华为;

import java.util.Scanner;

public class 字符串加解密 {

    /**
     * https://www.nowcoder.com/practice/2aa32b378a024755a3f251e75cbf233a?tpId=37&tqId=21252&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String firstLine=sc.nextLine();
        String secondLine=sc.nextLine();
        StringBuilder firstResult=new StringBuilder();
        for(int i=0;i<firstLine.length();i++){
            char c=firstLine.charAt(i);
            firstResult.append(encrypt(c));
        }
        System.out.println(firstResult);
        StringBuilder secondResult=new StringBuilder();
        for(int i=0;i<secondLine.length();i++){
            char c=secondLine.charAt(i);
            secondResult.append(decrypt(c));
        }
        System.out.println(secondResult);

    }

    public static char encrypt(char c){
        if(Character.isDigit(c)){
            return c=='9'?'0':(char)(c+1);
        }
        if(Character.isLetter(c)){
            if(c=='z'){
                return 'A';
            }else if(c=='Z'){
                return 'a';
            }else if(c>='a'){
                return (char)(c-31);
            }else{
                return (char)(c+33);
            }
        }
        return c;
    }

    public static char decrypt(char c){
        if(Character.isDigit(c)){
            return c=='0'?'9':(char)(c-1);
        }
        if(Character.isLetter(c)){
            if(c=='A'){
                return 'z';
            }else if(c=='a'){
                return 'Z';
            }else if(c>'a'){
                return (char)(c-33);
            }else{
                return (char)(c+31);
            }
        }
        return c;
    }

}
