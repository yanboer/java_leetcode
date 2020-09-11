package interesting;
import java.util.*;

/**
 *  HashMap 优化
 */

/**
 *如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
 * 例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 *  
 *
 * 示例 1：
 *
 * 输入: [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释:
 * 最长的斐波那契式子序列为：[1,2,3,5,8] 。
 * 示例 2：
 *
 * 输入: [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释:
 * 最长的斐波那契式子序列有：
 * [1,11,12]，[3,11,14] 以及 [7,11,18] 。
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * （对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LenLongestFibSubseq {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8};       //结果    [1,2,3,5,8]     最长为 5

        LenLongestFibSubseq l = new LenLongestFibSubseq();
        int result = l.lenLongestFibSubseq(a);
        System.out.println(result);
    }
    // Map<Integer,Integer> map = new HashMap<>();

    //两个数相加可能暴 int
    // 暴力  ===》超时
    // public int lenLongestFibSubseq(int[] A) {
    //     int size = A.length;

    //     for(int i = 0;i <= size - 1;i++){
    //         map.put(A[i],i);    //A[i] 作为 key，index 作为 value，方便之后获取 index
    //     }
    //     int result = 0;
    //     for(int i = 0;i <= size - 1;i++){
    //         for(int j = i + 1;j <= size - 1;j++){
    //             result = Math.max(result,cal(i,j,A));
    //         }
    //     }
    //     return result == 2 ? 0 : result;
    // }

    // public int cal(int head,int next,int[] A){
    //     int sum = 2;
    //     int a = A[head];
    //     int b = A[next];
    //     int value = a + b;
    //     while(map.containsKey(value) && b <= A[A.length - 1]){
    //         sum++;
    //         int temp = b;
    //         b = value;
    //         a = temp;
    //         value = a + b;
    //     }
    //     return sum;
    // }

    //dp
    /**
     优化思路：使用 map 存储数组,然后使用 map.containsKey() 方法确定是否有 k存在使得 A[k] + A[i] == A[j]
     key：数组的值
     value：数组索引(方便获取索引)
     */
    public int lenLongestFibSubseq(int[] A) {
        int size = A.length;
        int[][] f = new int[size][size];    //f[i][j] 表示以A[i]、A[j] 结尾的最长斐波那契式的长度

        Map<Integer,Integer> map = new HashMap<>();     //创建哈希表存储 A 数组，使得查询效率提高
        for(int i = 0;i <= size - 1;i++){
            map.put(A[i],i);
        }

        for(int i = 0;i <= size - 1;i++){   //初始化
            Arrays.fill(f[i],2);
        }

        for(int i = 1;i <= size - 1;i++){
            for(int j = i + 1 ;j <= size - 1;j++){
                if(A[j] > 2 * A[i]){
                    break;
                }
                int value = A[j] - A[i];    //当可以确定一个斐波那契式的时候，k 值是确定的
                if(map.containsKey(value)){
                    int k = map.get(value);
                    f[i][j] = f[k][i] + 1;
                }
                else{
                    f[i][j] = 2;
                }
            }
        }

        int result = 0; //结果
        for(int i = 0;i <= size - 1;i++){
            for(int j = 0;j <= size - 1;j++){
                result = Math.max(result,f[i][j]);
            }
        }
        return result == 2 ? 0 : result;
    }
}
