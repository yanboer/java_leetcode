package pointer;

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *  
 *
 * 提示：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindow m = new MinWindow();
        String res = m.minWindow(s,t);
        System.out.println(res);
    }
    //双指针
    /**
         思路：HashMap 存储 T 中的字符和它出现的次数
         left、right 指向 S 的开始，默认 right++，当 S中出现了 T 中的字符时， HashMap 中该字符出现次数 - 1，
         当 HashMap 中有元素次数 == 0 时，证明 S 满足了 T 中的一个字符的出现次数 ，count++。
         当 count == map.size() 时，满足条件，更新最小子串长度。
         当 map.get(s.charAt(left)) < 0时，left++

     */
    public String minWindow(String s, String t) {
        if(s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < t.length();i++){
            int value = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),value + 1);
        }
        int leng = map.size();  // t 中元素个数

        int l = 0;
        int count = 0;  //统计左右指针区域内元素个数
        int min = s.length() + 1;   //最小子串长度  ===>最终结果可能是 s的长度，所以 min 初始化为 s.length() + 1
        String res = "";    //结果

        for(int r = 0;r < s.length();r++){
            if(map.containsKey(s.charAt(r))){   //map 里有索引 r 对应的 字符
                int temp = map.get(s.charAt(r));
                if(temp == 1){      //满足条件 count++
                    count++;
                }
                map.put(s.charAt(r),temp - 1);      //出现次数 - 1
                while(!map.containsKey(s.charAt(l)) || map.get(s.charAt(l)) < 0){    //左边字符不在 T 中 或者 左边字符多了
                    if(map.containsKey(s.charAt(l))){
                        map.put(s.charAt(l),map.get(s.charAt(l)) + 1); //值 +1
                    }
                    l++;
                }
                if(count == leng){   //满足条件更新 min
                    if(min > r - l + 1){
                        min = r - l + 1;
                        res = s.substring(l,r + 1);
                    }
                }
            }
        }
        // System.out.println(min);
        return  res;
    }
}
