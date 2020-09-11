package dp;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber {
    public static void main(String[] args) {

    }

    /**
     *
     *      dp[i] = dp[a2] * 2 || dp[a3] * 3 || dp[a5] * 5
     *
     *      if(dp[i] == dp[a2] * 2) a2++;
     *      if(dp[i] == dp[a3] * 3) a3++;
     *      if(dp[i] == dp[a5] * 5) a5++;
     *
     *
     *      a2 a3 a5 分别是指向 2 3 5 三个质因子的指针
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];  //dp[n] 表示第 n 个丑数是谁

        //丑数是 2 3 5 的倍数

        dp[1] = 1;
        int a2 = 1;      //2的指针
        int a3 = 1;      //3的指针
        int a5 = 1;      //5的指针

        for(int i = 2;i<=n;i++){
            int temp = Math.min(dp[a2] * 2,dp[a3] * 3);
            dp[i] = Math.min(temp,dp[a5] * 5);

            if(dp[i] == dp[a2] * 2) a2++;
            if(dp[i] == dp[a3] * 3) a3++;
            if(dp[i] == dp[a5] * 5) a5++;
        }

        return dp[n];

    }
}
