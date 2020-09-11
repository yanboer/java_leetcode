package dp;
import java.util.*;
/**
 *  完全背包  ====》 考虑组合问题     ====》统计次数
 */

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum4 {
    public static void main(String[] args) {

    }
    public int combinationSum4(int[] nums, int target) {
        int y_leng = nums.length;
        int x_leng = target;

        if(y_leng == 0){
            return 0;
        }

        if(x_leng == 0){
            return 1;
        }

        Arrays.sort(nums);  //升序排序

        //dp[i] 表示 i 的方案个数 ===> dp[i] = dp[i - nums[j]]
        /*
        例：
            nums = [1, 2, 3]
            target = 4
          dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

          dp[0] = 1;
          dp[1] = dp[1 - 1] = 1;
          dp[2] = dp[2 - 1] + dp[2 - 2];
          dp[3] = dp[3 - 1] + dp[3 - 2] + dp[3 - 3];
          dp[4] = dp[4 - 1] + dp[4 - 2] + dp[4 - 3];
        */
        int[] dp = new int[x_leng + 1];

        dp[0] = 1;


        for(int i = 1;i <= target;i++){     //target 在外
            for(int j = 0;j <= nums.length - 1;j++){     //nums 在内
                if(i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }
}
