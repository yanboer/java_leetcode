package dp;
import java.util.*;
/**
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 *
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 *
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 *
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 *
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 *  
 *
 * 提示：
 *
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s 中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCost {
    public static void main(String[] args) {
        String s = "abaac";
        int[] cost = {1,2,3,4,5};

        MinCost minCost = new MinCost();
        int result = minCost.minCost(s, cost);
        System.out.println(result);
    }

    public int minCost(String s, int[] cost) {
        int size = s.length();
        int[][] f = new int[size][27];  //0-25 表示 'a'-'z' 26表示之前的都删除完了
        for(int i = 0;i <= size - 1;i++){
            Arrays.fill(f[i],1000000000);       //初始化成最大值(之后要比较取小的数)
        }
        char start = s.charAt(0);
        f[0][start - 'a'] = 0;  //没删除第一个字符
        f[0][26] = cost[0];     //删除了第一个字符

        for(int i = 1;i <= size - 1;i++){
            for(int j = 0;j <= 26;j++){
                f[i][j] = f[i - 1][j] + cost[i];    //删除
                int temp = s.charAt(i) - 'a';
                for(int k = 0;k <= 26;k++){
                    if(temp != k){
                        f[i][temp] = Math.min(f[i][temp],f[i - 1][k]);    //不删除
                    }
                }
            }
        }

        int res = 1000000000;
        for(int i = 0;i <= 26;i++){
            res = Math.min(res,f[size - 1][i]);
        }
        return res;
    }

    //贪心
    // public int minCost(String s, int[] cost) {
    //     int size = s.length();

    //     int res = 0;    //最小删除成本
    //     for(int i = 0;i <= size - 2;i++){
    //         if(s.substring(i,i+1).equals(s.substring(i+1,i+2))){
    //             res += Math.min(cost[i],cost[i + 1]);   //选择最小的代价
    //             if(cost[i] > cost[i + 1]){
    //                 cost[i + 1] = cost[i];  //价值覆盖掉    ===>因为选择最小的代价，留下来的应该是另一个代价
    //             }
    //         }
    //     }

    //     return res;
    // }
}
