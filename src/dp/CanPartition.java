package dp;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition {
    public static void main(String[] args) {

        int[] a =  new int[]{23,13,11,7,6,5,5};

        CanPartition canPartition = new CanPartition();
        boolean result = canPartition.canPartition(a);
        System.out.println(result);
    }

    //求出数组所有元素之和 sum ，sum为奇数则返回false，为偶数则 判断数组元素是否可以凑出 sum/2 ==》即典型的 01背包问题
    public boolean canPartition(int[] nums) {
        if(nums.length == 0){
            return true;
        }

        int sum = 0;
        for(int i = 0;i <= nums.length - 1;i++){
            sum += nums[i];
        }
        if(sum%2 == 1){     //和为奇数则不可能平分    ====》返回 false
            return false;
        }

        int target = sum/2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];  //dp[i][j] 表示前 i 个元素是否可以凑齐 j

        // Arrays.fill(dp[0],true);
        dp[0][0] = true;

        for(int i = 1;i <= nums.length;i++){
            for(int j = 0;j <= target;j++){
                dp[i][j] = dp[i - 1][j];        //不选(选不了)
                if(j >= nums[i - 1]){       //选或者不选
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }


        return dp[nums.length][target];
    }
}
