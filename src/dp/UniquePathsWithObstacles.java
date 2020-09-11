package dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        int[][] b = {
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
        };

        UniquePathsWithObstacles u = new UniquePathsWithObstacles();
        int result = u.uniquePathsWithObstacles(b);
        System.out.println(result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) { //起点或终点有障碍物
            return 0;
        }
        boolean[] line = new boolean[m];    //标记一行是否全是障碍物
        boolean[] colomn = new boolean[n];  //标记一列是否全是障碍物

        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (obstacleGrid[i][j] == 0) {
                    line[i] = true;
                    colomn[j] = true;
                }
            }
        }
        for (int i = 0; i <= m - 1; i++) {    //一行是否全是障碍物
            if (line[i] == false) {
                return 0;
            }
        }
        for (int i = 0; i <= n - 1; i++) {      //一列是否全是障碍物
            if (colomn[i] == false) {
                return 0;
            }
        }

        int[][] f = new int[m][n];  //f[i][j] 表示从 (0,0) 到 (i,j) 的路径总数
        f[0][0] = 1;

        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }
}


