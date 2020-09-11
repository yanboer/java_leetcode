package dp;


/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {
    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        int result = movingCount.movingCount(2, 3, 1);
        System.out.println(result);
    }

    int sum = 0;    //能到达的格子数
    boolean[][] color = null;   //标记每个格子的访问情况
    public int movingCount(int m, int n, int k) {
        if(k == 0){
            return 1;
        }

        color = new boolean[m][n];
        dfs(0,0,m,n,k);

        return sum;
    }

    public void dfs(int x,int y,int m,int n,int k){ //x 坐标，y 坐标
        if(x >= n){  //越界
            return;
        }
        if(y >= m){  //越界
            return;
        }
        if(x < 0 || y < 0){ //越界
            return;
        }
        if(color[y][x] == true){        //访问过
            return;
        }
        if(subNum(x) + subNum(y) > k){  //行列之和大于 k
            return;
        }

        sum++;      //格子数 + 1
        color[y][x] = true;     //标记
        dfs(x + 1,y,m,n,k);
        dfs(x - 1,y,m,n,k);
        dfs(x,y + 1,m,n,k);
        dfs(x,y - 1,m,n,k);
    }

    //返回该数字各个位数之和
    public int subNum(int n){
        String temp = String.valueOf(n);
        int leng = temp.length();

        int[] result = new int[2];      //m,n <= 100
        for(int i = 0;i <= leng - 1;i++){
            result[i] = Integer.parseInt(temp.substring(i,i+1));
        }

        int res = 0;    //各个位数之和
        for(int i = 0;i <= 1;i++){
            res += result[i];
        }

        return res;
    }
}
