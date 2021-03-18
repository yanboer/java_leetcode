import java.util.*;


public class Solution {
    public static void main(String[] args) {
        String s = "abc";
        String pattern = "bc";

        int i = indexOf(s, pattern);
        System.out.println(i);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 字符串查找
     * @param s string字符串 被查找的字串
     * @param pattern string字符串 要查找的模式串
     * @return int整型
     */
    public static int indexOf (String s, String pattern) {
        // write code here
        int n1 = s.length();
        int n2 = pattern.length();

        int res = -1;        //结果
        for(int i = 0;i + n2 <= n1;i++){
            if(s.substring(i,i + n2).equals(pattern)){
                res = i;
                return res;
            }
        }

        return res;
    }
}
