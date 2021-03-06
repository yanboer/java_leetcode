package dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] a = new int[]{-2,-3,-1};
        int[] b = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        maxSubArray.maxSubArray(b);
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];        //dp[n] 表示 以 n 结尾的最大子序列和
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] =  Math.max(dp[i - 1]+nums[i],nums[i]);
        }

        int result = dp[0];
        for(int temp:dp){
            result = temp>result?temp:result;
        }
        return result;
    }
}
