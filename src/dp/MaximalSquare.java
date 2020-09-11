package dp;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaximalSquare {
    public static void main(String[] args) {

        char[][] a = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'},
        };

//        char[][] a = {{'0','1'}};

        MaximalSquare maximalSquare = new MaximalSquare();
        int result = maximalSquare.maximalSquare(a);
        System.out.println(result);

    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }

        int x_length = matrix[0].length;
        int y_length = matrix.length;

        int[][] dp = new int[y_length + 1][x_length + 1];   //dp[i][j] 表示以(i,j)为右下角点的最大正方形边长

        if(matrix[0][0] == '1'){
            dp[0][0] = 1;
        }
        else {
            dp[0][0] = 0;
        }

        for(int i = 0;i<=y_length - 1;i++){
            for(int j = 0;j<=x_length - 1;j++){

                if(matrix[i][j] == '1') {
                    int temp = Math.min(dp[i][j], dp[i][j + 1]);
                    dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;
                }
                else {
                    continue;
                }
            }
        }

        int result = 0;     //结果

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[i].length;j++){
                result = Math.max(result,dp[i][j]);
            }
        }
        return result*result;
    }
}
