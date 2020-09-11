package dp;

/**
 *
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]
 * 。 请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * 2 <= n <= 58
 */
public class CuttingRope {
    public static void main(String[] args) {

        CuttingRope cuttingRope = new CuttingRope();
        int result = cuttingRope.cuttingRope(10);
        System.out.println(result);
    }

    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1; // 题目要求必须切割至少一次 n>1并且m>1
        }

        int[] dp = new int[n + 1]; // dp[i] 表示长度 i 时乘积最大
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) { // 长度为 i 的绳子被切成 j 和 i-j 两段，i 趋于 n 后，即可以求出长度为 n 的绳子的最大乘积
            for (int j = 1; j < i; j++) { // i-j>0 ,i>j

                // 长度为 i 的绳子的最大乘积要么是dp[i],要么是 dp[j] * dp[i - j]
                // dp[i] 取所有循环中计算出的最大的 dp[j] * dp[i - j]
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

}
