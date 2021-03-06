package dp;
import java.util.*;
/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS {
    public static void main(String[] args) {
//        int[] a = new int[]{10,9,2,5,3,7,101,18};
        int[] a = new int[]{1,3,6,7,9,4,10,5,6};

        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int result = lengthOfLIS.lengthOfLIS(a);
        System.out.println(result);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length + 1];    //dp[i] 表示 以 nums[i] 结尾

        Arrays.fill(dp,1);

        for(int i = 2;i<=nums.length;i++){
            for(int j = 0;j<=i - 2;j++){
                if(nums[i - 1] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j + 1]+1);
                }
            }
        }

        return dp[nums.length];
    }
}
