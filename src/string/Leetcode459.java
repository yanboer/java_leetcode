package string;
/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 未完成
 */
public class Leetcode459 {
    public static void main(String[] args) {
        Leetcode459 l = new Leetcode459();
        boolean res = l.repeatedSubstringPattern("aba");
        boolean res2 = l.repeatedSubstringPattern("abcabcabcabc");
        System.out.println(res);
        System.out.println(res2);
    }
    public boolean repeatedSubstringPattern(String s) {
        boolean flag = false;
        for(int i = 0;i < s.length();i++){  //结尾位置
            if(check(i,s)){
                flag = true;
                return true;
            }
        }
        return flag;
    }

    public boolean check(int index,String s){
        boolean flag = true;
        int len = index - 0 + 1;

        String temp = s.substring(0,len);

        for(int i = index;i < s.length();i += len){
            if(i + len > s.length() || !temp.equals(s.substring(i + 1,i + len))){
                flag = false;
                return false;
            }
        }
        return flag;
    }
}