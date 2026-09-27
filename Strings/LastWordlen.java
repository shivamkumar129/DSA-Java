package Strings;

import java.util.Scanner;

public class LastWordlen {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(lengthOfLastWord(str));
        sc.close();

    }
     static  int lengthOfLastWord(String s) {
        int len=0;
        String str=s.trim();
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)!=' '){
                len++;
            }else{
                break;
            }
        }
        return len;
    }
}
