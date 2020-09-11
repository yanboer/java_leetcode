package dp;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public static void main(String[] args) {


    }
    public int maxProduct(int[] nums) {
        int leng = nums.length;
        if(leng == 0){
            return 0;
        }
        if(leng == 1){
            return nums[0];
        }
        int[] dp = new int[leng + 1];    //dp[i] 表示以 nums[i - 1]结尾的子数组的最大乘积(正)
        int[] minus_dp = new int[leng + 1];//dp[i] 表示以 nums[i - 1]结尾的子数组的最大乘积(负)


        if(nums[0] > 0) dp[1] = nums[0];
        if(nums[0] < 0) minus_dp[1] = nums[0];


        for(int i = 2;i<=leng;i++){
            if(nums[i - 1] == 0){
                dp[i] = 0;
                minus_dp[i] = 0;
            }
            if(nums[i - 1] > 0){
                dp[i] = dp[i - 1] * nums[i - 1];
                minus_dp[i] = minus_dp[i - 1] * nums[i - 1];

                if(dp[i - 1] == 0){     //特殊情况
                    dp[i] = nums[i - 1];
                }
            }
            if(nums[i - 1] < 0){
                dp[i] = minus_dp[i - 1] * nums[i - 1];
                minus_dp[i] = dp[i - 1] * nums[i - 1];

                if(dp[i - 1] == 0){     //特殊情况
                    minus_dp[i] = nums[i - 1];
                }
            }
        }


        int result = 0; //结果
        for(int i = 1;i<=leng;i++){
            result = Math.max(dp[i],result);
        }
        return result;
    }
}
