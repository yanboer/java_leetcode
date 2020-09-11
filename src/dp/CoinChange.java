package dp;
import java.util.*;
/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    public static void main(String[] args) {

        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(new int[]{1,2,5},11);

        System.out.println(result);
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];   //dp[i] 表示凑够 i的金额所需的最少硬币个数,凑不够为 (amount + 1) + 1(n个)

        Arrays.fill(dp,amount + 1);     //最大值填充
        dp[0] = 0;  //初始化

        /**
         若 i - coins[j] == 0,表示能凑齐，最终结果就是 0 + 1(n个)
         若 i - coins[j] != 0,表示凑不齐，最终结果就是 (amount + 1) + 1(n个)
         */

        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }
}
