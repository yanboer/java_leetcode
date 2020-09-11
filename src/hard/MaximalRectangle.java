package hard;

/**
 *给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] a = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'},
        };      //预期    6
        char[][] b = {
                {}
        };      //预期    0
        char[][] c = {};    //预期    0
        char[][] d = {
                {'1','0'},
        };      //1

        MaximalRectangle m = new MaximalRectangle();
        int maxArea = m.maximalRectangle(d);
        System.out.println(maxArea);
    }
    //dp
    /**
     dp[i][j] 表示以 (i,j) 为右下角的矩形的最大面积
     f[i][j] 表示 (i,j) 点的最大宽度(横着的)

     dp[i][j] = Math.max(Math.min(f[i][j]) * 高度);

     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n]; //dp[i][j] 表示以 (i,j) 为右下角的矩形的最大面积
        int[][] f = new int[m][n];    //f[i][j] 表示 (i,j) 点的最大宽度(横着的)

        if(matrix[0][0] == '0'){        //初始化
            f[0][0] = 0;
            dp[0][0] = 0;
        }
        else{
            f[0][0] = 1;
            dp[0][0] = 1;
        }
        for(int j = 1;j <= n - 1;j++){
            if(matrix[0][j] == '1'){
                f[0][j] = f[0][j - 1] + 1;
            }
            else{
                f[0][j] = 0;
            }
        }
        for(int i = 1;i <= m - 1;i++){
            for(int j = 0;j <= n - 1;j++){
                if(j == 0){
                    if(matrix[i][0] == '1'){
                        f[i][0] = 1;
                    }
                    else{
                        f[i][0] = 0;
                    }
                }
                else{
                    if(matrix[i][j] == '1'){
                        f[i][j] = f[i][j - 1] + 1;
                    }
                    else{
                        f[i][j] = 0;
                    }
                }
            }
        }


        for(int i = 0;i <= m - 1;i++){
            for(int j = 0;j <= n -1;j++){
                int maxArea = 0;    //求矩形最大面积
                int minleng = 1000000;  //求最小宽度
                for(int k = i;k >= 0;k--){
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                        break;  //退出 k 的循环
                    }
                    else{
                        int width = i - k + 1;  //矩形高度
                        minleng = Math.min(minleng,f[k][j]);    //当前最小的矩形宽度

                        maxArea = Math.max(maxArea,width * minleng);
                        dp[i][j] = maxArea;
                    }
                }
            }
        }
        int result = 0; //结果
        for(int i = 0;i <= m - 1;i++){
            for(int j = 0;j <= n - 1;j++){
                result = Math.max(result,dp[i][j]);
            }
        }
        return result;
    }
}
