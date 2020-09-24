package pointer;
import java.util.*;
/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int[] nums2 = {0,0,0,0};
        int target = 0;

        FourSum f = new FourSum();
        List<List<Integer>> res = f.fourSum(nums2, target);
        System.out.println(res.toString());
    }
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i <= n - 4;i++){
            if(i > 0 && nums[i] == nums[i - 1]){ //重复
                continue;
            }
            for(int j = i + 1;j <= n - 3;j++){
                if(j > 0 && nums[j] == nums[j - 1] && j - 1 != i){ //重复
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                while(l < r){
                    if(nums[i] + nums[j] + nums[l] + nums[r] == target){
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(new LinkedList<>(list));
                        System.out.println(res.toString());

                        int left = l;
                        int right = r;
                        while(nums[++l] == nums[left] && l < r);     //去重
                        while(nums[--r] == nums[right] && l < r);
                    }
                    else if(nums[i] + nums[j] + nums[l] + nums[r] > target){
                        r--;
                    }
                    else if(nums[i] + nums[j] + nums[l] + nums[r] < target){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
