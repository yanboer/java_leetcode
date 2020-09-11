package dp;
import java.util.*;

/**
 *  完全背包  ====》 不考虑组合问题     ====》统计次数
 */

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToChange {
    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
//        int result = waysToChange.waysToChange(10);
        int result = waysToChange.waysToChange(929782);
        System.out.println(result);
    }

//    public int waysToChange(int n) {
//        if(n == 0){
//            return 1;
//        }
//
//
//        int[] coins = {1,5,10,25};
//        int[][] dp = new int[4 + 1][n + 1]; //dp[i][j] 表示前 i 种硬币表示 j 分的表示法
//        Arrays.fill(dp[1],1);       //第一种硬币表示任意 分钱 表示法都是 1
//
////        for(int i = 0;i<=4;i++){
////            dp[i][0] = 1;       //前任意种硬币表示 0分钱 表示法都是 1(全不取)
////        }
//
////        dp[0][0] = 1;
//
//        for (int i = 2; i <= 4; i++) {  //前 2 种硬币开始算起
//            for (int j = n; j >= 0; j--) {
//                for (int k = 0; k * coins[i - 1]<= j; k++) {
//                    //dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
//                    dp[i][j] += (dp[i - 1][j - k * coins[i - 1]])%1000000007;
//                }
//            }
//        }
//
//        return dp[4][n];
//    }

    //优化 ====》减少一层循环
    public int waysToChange(int n) {
        if(n == 0){
            return 1;
        }


        int[] coins = {1,5,10,25};
        int[][] dp = new int[4 + 1][n + 1]; //dp[i][j] 表示前 i 种硬币表示 j 分的表示法
        Arrays.fill(dp[1],1);       //第一种硬币表示任意 分钱 表示法都是 1

//        for(int i = 0;i<=4;i++){
//            dp[i][0] = 1;       //前任意种硬币表示 0分钱 表示法都是 1(全不取)
//        }

//        dp[0][0] = 1;

        for (int i = 2; i <= 4; i++) {  //前 2 种硬币开始算起
            for (int j = 0; j <= n; j++) {      //必须从下往上
               dp[i][j] += (dp[i - 1][j])%1000000007;        //不选第 i 种物品
                if(j >= coins[i - 1]){
                    dp[i][j] += (dp[i][j - coins[i - 1]])%1000000007;        //选第 i 种物品
                }
            }
        }

        return dp[4][n]%1000000007;
    }
}
