package dp;
import java.util.*;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSquares {
    public static void main(String[] args) {

        NumSquares numSquares = new NumSquares();
        int result = numSquares.numSquares(12);
        System.out.println(result);
    }
    public int numSquares(int n) {
        int[] num = new int[n + 1];  //完全平均数集合

        set_num(num,n);


        int[] dp = new int[n+1];   //dp[i] 表示数字 i 所需使用的最少完全平方数个数

        Arrays.fill(dp,1000);

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            for(int j = 0;num[j + 1]<=i;j++){
                dp[i] = Math.min(dp[i],dp[i - num[j + 1]] + 1);
            }
        }

        return dp[n];

    }
    public void set_num(int[] num,int n){
        for(int i = 0;i<=n;i++){
            num[i] = i * i;
            if(num[i] > n){
                return;
            }
        }
    }
}
