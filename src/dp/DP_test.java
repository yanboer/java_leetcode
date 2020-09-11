package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 牛牛。。。。
 */
public class DP_test {
    public static void main(String[] args) {
        DP_test dp_test = new DP_test();
//        int result = dp_test.hh(3, 3,0,0);
//        System.out.println(result);
    }

    /**
     *
     * @param n     台阶总数
     * @param m     一次最多几个台阶
     * @return
     */
//    public int sum_pace(int n,int m){
//
//        int[][] dp = new int[m + 1][n + 1];     //dp[i][j] 前 i 种台阶走法表示 j 个台阶的总数
//
//        int[] a = new int[3];
//
//        int[] arry = new int[m];
//        for (int i = 0; i <= m - 1; i++) {
//            arry[i] = i + 1;
//        }
//
//        Arrays.fill(dp[1],1);
//
//        for (int i = 2; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                dp[i][j] += dp[i - 1][j];
//                if(arry[i - 1] <= j) {
//                    dp[i][j] += dp[i][j - arry[i - 1]];
//                }
//            }
//        }
//
//        return dp[m][n];
//    }

    static Map<Integer,Integer> map = new HashMap<>();

//    public static int hh(int n, int m, int x,int y){
//
//        if(n == 0)
//            return 1;
//        if(n < 0)
//            return 0;
//        if(n > 0){
//            if(map.keySet().contains(""+n+x+y)){
//                return map.get(""+n+x+y);
//            }
//            int val = 0;
//            for(int i = 1; i <= m; i++){
//                if(i == x || i == y)
//                    continue;
//                val += hh(n-i,m,y,i)%mod;
//            }
//            map.put(""+n+x+y,val%mod);
//            return val%mod;
//        }
//        return 0;
//    }
}
