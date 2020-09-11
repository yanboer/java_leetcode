package dp;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDecodings {
    public static void main(String[] args) {

//        String s = "12";
//        String s = "226";
//        String s = "101";
//        String s = "110";
        String s = "230";

//        System.out.println(s.substring(0,1).equals("1"));
//        System.out.println(s.charAt(0));
//        System.out.println(s.charAt(1));
//        System.out.println(s.charAt(2));

        NumDecodings numDecodings = new NumDecodings();
        int result = numDecodings.numDecodings(s);
        System.out.println(result);

    }
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];     //dp[n] 表示以 n 结尾的字符的编码方法数

        if(s.substring(0,1).equals("0")){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        dp[1] = 1;
        if(s.substring(0,1).equals("1") || (s.substring(0,1).equals("2") && 0 < Integer.parseInt(s.substring(1,2)) && Integer.parseInt(s.substring(1,2))<7)){     //前两位数字 < 26
            dp[2] = 2;
        }
        if((s.substring(0,1).equals("1") || s.substring(0,1).equals("2")) && s.substring(1,2).equals("0")){
            dp[2] = 1;
        }
        if(Integer.parseInt(s.substring(0,1))>2 && Integer.parseInt(s.substring(1,2)) != 0){
            dp[2] = 1;
        }
        if(Integer.parseInt(s.substring(0,1))>2 && Integer.parseInt(s.substring(1,2)) == 0){
            dp[2] = 0;
        }
        if(s.substring(0,1).equals("2") && Integer.parseInt(s.substring(1,2)) > 6){
            dp[2] = 1;
        }

        for(int i = 3;i<=length;i++){
            if(s.substring(i - 3,i - 2).equals("0") && s.substring(i - 2,i -1).equals("0")){        //两个 0 直接无解
                dp[i] = 0;
            }
            if(s.substring(i - 2,i -1).equals("0")){        //第 i 位只能单独放在最后 dp[i] = dp[i - 1]
                dp[i] = dp[i - 1];
            }
            if(s.substring(i - 1,i).equals("0") && 0<Integer.parseInt(s.substring(i - 2, i - 1)) && Integer.parseInt(s.substring(i - 2, i - 1))<=2){
                dp[i] = dp[i - 2];
            }
            if((s.charAt(i - 1) == '0'  &&(Integer.parseInt(s.substring(i - 2, i - 1)) == 0)) || (Integer.parseInt(s.substring(i - 2, i - 1))>2 && Integer.parseInt(s.substring(i - 1, i)) == 0)){
                dp[i] = 0;
            }
            if((Integer.parseInt(s.substring(i - 2, i - 1))==1 && Integer.parseInt(s.substring(i - 1, i)) != 0)|| (Integer.parseInt(s.substring(i - 2, i - 1))==2 &&
                    0<Integer.parseInt(s.substring(i - 1, i)) && Integer.parseInt(s.substring(i - 1, i))<=6) ){
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            if((Integer.parseInt(s.substring(i - 2, i - 1))>2  && Integer.parseInt(s.substring(i - 1, i)) != 0)|| (Integer.parseInt(s.substring(i - 2, i - 1)) == 2 &&
                    Integer.parseInt(s.substring(i - 1, i)) > 6) ){
                dp[i] = dp[i - 1];
            }

        }


        return dp[length];
    }
}
