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
        if(s.length() == 0){
            return 0;
        }
        int n = s.length();
        int slow = 0;
        int fast = 0;

        int result = 1;    //结果


        // Map<String,Integer> map = new HashMap<>();  //key 是 slow、fast 对应的字符，value是出现的次数
        // map.put(s.substring(0,1),1);

        // while(slow <= fast && fast <= n - 2){   //注意是 n - 2
        //     fast++;
        //     map.put(s.substring(fast,fast + 1),map.getOrDefault(s.substring(fast,fast + 1),0) + 1); //放入 map
        //     while(map.get(s.substring(fast,fast + 1)) > 1){ //出现重复
        //         map.put(s.substring(slow,slow + 1),map.getOrDefault(s.substring(slow,slow + 1),0) - 1); // -1
        //         slow++;
        //     }
        //     result = Math.max(result,fast - slow + 1);
        // }

        Set<String> set = new HashSet<>();
        set.add(s.substring(0,1));

        while(slow <= fast && fast <= n - 2){   //n - 2
            fast++;
            while(set.contains(s.substring(fast,fast + 1))){    //重复了
                set.remove(String.valueOf(s.substring(slow,slow + 1))); //移除慢指针对应的字符
                slow++;
            }
            set.add(s.substring(fast,fast + 1));
            result = Math.max(result,fast - slow + 1);  //更新值
        }

        return result;
    }
}
