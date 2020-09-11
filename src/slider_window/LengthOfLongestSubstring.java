package slider_window;
import java.util.*;
/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * slider window
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int result = l.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
    //slider window
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        int n = s.length();

        int result = 1; //结果

        int sum = 1;    //当前字符串中长度
        while(left <= right && right <= n - 2){ //right = n - 1时，right++后，会溢出
            if(checkS(s,left,right)){   //现在字符串有重复
                left++;
                if(check(s,left,right,left - 1)){  //移除的字符新字符串里有
                    sum = sum;
                }
                else{
                    sum -= 1;
                }
            }
            else{   //不重复
                right++;
                if(check(s,left,right - 1,right)){ //新字符之前字符串有
                    sum = sum;
                }
                else{   //没有
                    sum += 1;
                    result = Math.max(sum,result);
                }
            }
        }
        return result;
    }

    //检查 (left,right) 中的 s 是否有重复
    public boolean checkS(String s,int left,int right){
        boolean flag = false;
        List<String> list = new LinkedList<>();
        for(int i = left;i <= right;i++){
            if(list.contains(s.substring(i,i + 1))){
                flag = true;
            }
            else{
                list.add(s.substring(i,i + 1));
            }
        }

        return flag;
    }

    //a 位置字符在 (left,right) 中是否存在
    public boolean check(String s,int left,int right,int a){
        boolean flag = false;
        for(int i = left;i <= right;i++){
            if(s.substring(a,a + 1).equals(s.substring(i,i + 1))){
                flag = true;
            }
        }
        return flag;
    }
}
