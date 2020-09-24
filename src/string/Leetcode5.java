package string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode5 {
    public static void main(String[] args) {
        Leetcode5 l = new Leetcode5();
//        String result = l.longestPalindrome("babad");
        String result = l.longestPalindrome("cabac");
        System.out.println(result);
    }
    //遍历每个回文串中心点
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }

        int result = 0; //结果的左边界
        int len = 0;    //右边界

        //奇数个的
        for(int i = 0;i < n;i++){   //遍历回文串中心点
            int tem_res = 0;       //暂时左边界
            int tem_len = 0;        //暂时右边界

            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && right < n && s.substring(left,left + 1).equals(s.substring(right,right + 1))){
                tem_len = right;            //暂时右边界
                tem_res = left;                //暂时中间值
                if(tem_len - tem_res > len - result){       //大于之前的结果
                    result = tem_res;       //更新
                    len = tem_len;
                }
                left--;
                right++;
            }
        }

        //偶数个的
        for(int i = 0;i < n;i++){   //遍历回文串中心点
            int tem_res = 0;       //暂时左边界
            int tem_len = 0;        //暂时右边界

            int left = i;           //左
            int right = i + 1;      //右
            while(left >= 0 && right < n && s.substring(left,left + 1).equals(s.substring(right,right + 1))){
                tem_len = right;            //暂时右边界
                tem_res = left;             //暂时左间值    ===》不能是 i ，因为左边界会变
                if(tem_len - tem_res > len - result){       //大于之前的结果
                    result = tem_res;       //更新
                    len = tem_len;
                }
                left--;
                right++;
            }
        }
        return s.substring(result,len + 1);
    }
}
