package other;
import java.util.*;
/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};


        TopKFrequent topKFrequent = new TopKFrequent();
        int[] result = topKFrequent.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(result));
    }
    //注意：前 k 高的频率，不是前 k 个
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];    //dp[i]表示以 nums[i]结尾的元素出现频率
        dp[0] = 1;
        for(int i = 1;i <= nums.length - 1;i++){
            if(nums[i] - nums[i - 1] == 0){
                dp[i] = dp[i - 1] + 1;
            }
            else{
                dp[i] = 1;
            }
        }

        for(int i = 1;i <= nums.length - 1;i++){
            if(dp[i] - dp[i - 1] == 1){
                dp[i - 1] = 0;
            }
        }

        List<Integer> list = new LinkedList<>();

        int[] a = new int[nums.length];
        // a = dp; //不能直接等于，等于只是指向 dp 数组
        for(int i = 0;i <= nums.length - 1;i++){
            a[i] = dp[i];
        }
        Arrays.sort(a);     //排序
        for(int i = nums.length - 1;i >= 0;i--){
            list.add(a[i]);
            if(list.size() == k){
                break;
            }
        }

        List<Integer> list2 = new LinkedList<>();
        for(int i = 0;i <= nums.length - 1;i++){
            if(list.contains(dp[i])){
                list2.add(nums[i]);
            }
        }

        int[] result = new int[k];

        Object[] obj = list2.toArray();
        for(int i = 0;i <= k - 1;i++){
            result[i] = (int)obj[i];
        }

        return result;
    }
}
