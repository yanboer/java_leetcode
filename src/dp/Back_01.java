package dp;

/**
 *  01背包  ====》 不考虑组合问题
 */
/**
 * 0-1 背包问题：给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi 。
 *
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
 */

/**
 * 设有三个背包，其重量分别为：16,15, 15；价值分别为： 45，25，25；请选择背包，使其重量不超过30，但价值最大。
 */

public class Back_01 {
    public static void main(String[] args) {
        Back_01 back_01 = new Back_01();

        int[] weight = {16,15,15};      //重量
        int[] value = {45,25,25};       //价值

        int best_solvtion = back_01.back_01(weight, value,32);

        System.out.println(best_solvtion);

    }


    //普通方法
    public int back_01(int[] weight,int[] value,int a){     //a 表示背包容量
        int[][] dp = new int[weight.length + 1][a + 1];  //dp[i][j] 表示将 i 件物品放入容量为 j 的背包时价值最大

        for(int i = 1;i<=weight.length;i++){       //第几件物品
            for(int j = 0;j <= a;j++){      //背包当前剩余容量
//                dp[i][j] = dp[i - 1][j];    //不选第 i 个物品
//
//                //选第 i 个物品
//                if (j >= weight[i - 1]) {       //当前剩余容量 >= weight[i]
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
//                }
                dp[i][j] = Math.max(dp[i][j],dp[i - 1][j]);     //不选
                if(j>=weight[i - 1]) {     //选
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }


        return dp[weight.length][a];
    }

//        //优化   ====》 二维数组变一维数组
//        public int back_01(int[] weight,int[] value,int a){     //a 表示背包容量
//        int[] dp = new int[a + 1];  //dp[j] 容量为 j 时价值最大
//
//        for(int i = 1;i<=weight.length;i++){       //第几件物品
//            for(int j = a;j>=weight[i - 1];j--){      //背包当前剩余容量
//                dp[j] = Math.max(dp[j],dp[j - weight[i - 1]] + value[i - 1]);
//            }
//        }
//
//
//        return dp[a];
//    }
}
