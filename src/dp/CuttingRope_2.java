package dp;

/**
 *
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）， 每段绳子的长度记为 k[0],k[1]...k[m -
 * 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * 
 * 提示：
 * 
 * 2 <= n <= 1000
 * 
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class CuttingRope_2 {
    public static void main(String[] args) {

        CuttingRope_2 cuttingRope = new CuttingRope_2();
        int result = cuttingRope.cuttingRope(120);
        System.out.println(result);
        System.out.println(Long.MAX_VALUE); // 9223372036854775807 --->19位
        System.out.println(Double.MAX_VALUE);
    }

    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1; // 题目要求必须切割至少一次 n>1并且m>1
        }

        double[] dp = new double[n + 1]; // dp[i] 表示长度 i 时乘积最大
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
        int result = (int) (dp[n] % 1000000007);

        return result;
    }

}
