package simple;
import java.util.*;
/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
//        String t = "ahbgdc";
        String t = "habgdc";

        IsSubsequence isSubsequence = new IsSubsequence();
        boolean result = isSubsequence.isSubsequence(s, t);
        System.out.println(result);
    }
//    public boolean isSubsequence(String s, String t) {
//        if(s.length() == 0){
//            return true;
//        }
//
//        if(t.length() == 0){
//            return false;
//        }
//
//        boolean[] dp = new boolean[s.length() + 1];     //dp[i] 表示 s 的前 i 个字符是否是 t 的子序列
//
//        int temp = 0;       //记录 dp[i - 1] 在 t 串中的位置
//
//        for(int i = 0;i <= t.length() - 1;i++){
//            if(s.substring(0,1).equals(t.substring(i,i+1))){    //判断dp[1]
//                dp[1] = true;
//                temp = i;
//                break;      //找到了就退出
//            }
//        }
//
//        for(int i = 2;i <= s.length();i++){
//            for(int j = 1;j <= t.length();j++){
//                if(s.substring(i - 1,i).equals(t.substring(j - 1,j)) && j - 1 > temp){  //s 的第 i 个和 t 的第 j 个匹配
//                    temp = j - 1;
//                    dp[i] = dp[i - 1];
//                    break;      //找到一个符合的就退出 j 的循环
//                }
//                if(dp[i - 1] == false){     //一个不匹配之后会全部不匹配，直接退出即可
//                    return false;
//                }
//            }
//        }
//
//        return dp[s.length()];
//    }
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        if(t.length() == 0){
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];     //dp[i] 表示 s 的前 i 个字符是否是 t 的前 j 个字符的子序列

        Arrays.fill(dp[0],true);    //s 长为 0，则为 true

        for(int i = 1;i <= s.length();i++){
            for(int j = 1;j <= t.length();j++){
                dp[i][j] = dp[i][j - 1];
                if(s.substring(i - 1,i).equals(t.substring(j - 1,j))){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
