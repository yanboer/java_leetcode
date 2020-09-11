package dp;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathSum {
    public static void main(String[] args) {

        int[][] a = {
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };

        MinPathSum minPathSum = new MinPathSum();
        int result = minPathSum.minPathSum(a);
        System.out.println(result);
    }
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }

        int x_leng = grid[0].length;
        int y_length = grid.length;

        int[][] dp = new int[y_length][x_leng]; //dp[i][j]表示 (0,0)到 (i,j) 的最短距离

        dp[0][0] = grid[0][0];

        for(int i = 0;i <= y_length - 1;i++){
            for(int j = 0;j <=x_leng - 1;j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0 && j >= 1){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                if(j == 0 && i >= 1){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                if(i>=1 && j>=1){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[y_length - 1][x_leng - 1];
    }
}
