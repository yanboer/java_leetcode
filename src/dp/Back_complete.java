package dp;
import java.util.*;
/**
 *  完全背包  ====》 不考虑组合问题
 */

/**
 * 设有三个背包，其重量分别为：16,15, 15；价值分别为： 45，25，25；请选择背包，使其重量不超过30，但价值最大。
 */

public class Back_complete {
    public static void main(String[] args) {
        int[] weight = {16,15,15};  //重量
        int[] value = {45,25,25};   //价值
        
        Back_complete back_complete = new Back_complete();
        int result = back_complete.back_complete(weight, value, 32);
        System.out.println(result);

    }
    //n 代表背包容量
    public int back_complete(int[] weight,int[] value,int n) {
        int[][] dp = new int[weight.length + 1][n + 1];   //dp[i][j] 表示 i 件物品放入容量为 j 的背包的价值最大值


        // dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - k*weight[i - 1] + k*value[i - 1]])
//        for (int i = 1; i <= weight.length; i++) {
//            for (int j = 0; j <= n; j++) {
//                for (int k = 0; k * weight[i - 1] <= j; k++) {
//                    dp[i][j] =Math.max(dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1], dp[i][j]);     //dp[i][j] 取最大值
////                    int temp = Math.max(dp[i - 1][j],dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
////                    dp[i][j] = Math.max(dp[i][j],temp);
//                }
//            }
//        }

        // dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - k*weight[i - 1] + k*value[i - 1]])    k~[0,n]
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j],dp[i - 1][j]);    //不选第 i 个
                if (j >= weight[i - 1]){    //选第 i 个
                    dp[i][j] = Math.max(dp[i][j],dp[i][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        return dp[weight.length][n];
    }
}
