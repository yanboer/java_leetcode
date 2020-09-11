package dp;
import java.util.*;
/**
 * 背包问题变形 ====》求最优解
 */

/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        int[] nums = {1,2,4,8};
        int[] nums = {1,2,3,5,7,6,4,8};


        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        List<Integer> result = largestDivisibleSubset.largestDivisibleSubset(nums);
        System.out.println("最优解：" + result);

    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int leng = nums.length;

        Set<Integer> set = new HashSet<>();    //结果

        Arrays.sort(nums);  //升序排序，如果原数组降序，则结果为 0。所以需要对数组进行升序排序

        if(leng == 0){
            return new LinkedList<>();
        }

        int[] dp = new int[leng + 1];   //dp[i] 表示以 nums[i - 1] 结尾的最大整除子集
        int[] color = new int[leng+1];      //color[i] = 1 表示 num[i - 1] 选了

        dp[1] = 1;

        for(int i = 2;i <= leng;i++){
            for(int j = 1;j < i;j++){
                dp[i] = Math.max(dp[i],1);
                if(nums[i - 1]%nums[j - 1] == 0){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    color[i] = 1;
                }
            }
        }

        int result = 0;     //最大整除子集的元素个数
        for(int i = 1;i<=leng;i++){
            result = Math.max(result,dp[i]);
        }

        System.out.println("最优解个数：" + result);


        for(int i = leng;i>=1;i--){
            if(color[i] == 1){
                set.add(nums[i - 1]);
            }
        }


        List<Integer> list = new LinkedList<>(set);

        return list;
    }
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        int leng = nums.length;
//
//        List<Integer> list = new LinkedList<>();    //结果
//
//        Arrays.sort(nums);  //升序排序，如果原数组降序，则结果为 0。所以需要对数组进行升序排序
//
//        if(leng == 0){
//            return list;
//        }
//
//        int[] dp = new int[leng + 1];   //dp[i] 表示以 nums[i - 1] 结尾的最大整除子集
//
//        dp[1] = 1;
//
//        for(int i = 2;i <= leng;i++){
//            for(int j = 1;j < i;j++){
//                dp[i] = 1;
//                if(nums[i - 1]%nums[j - 1] == 0){
//                    dp[i] = Math.max(dp[i],dp[j] + 1);
//                }
//            }
//        }
//        int result = 0;     //最大整除子集的元素个数
//        for(int i = 1;i<=leng;i++){
//            result = Math.max(result,dp[i]);
//        }
//
//        return list;
//    }
}
