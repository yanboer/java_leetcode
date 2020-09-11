package simple;

import java.util.*;


/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FindRepeatNumber2 {
    public static void main(String[] args) {

        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] nums = {2,3,1,0,2,5,3,3};
        int result = findRepeatNumber.findRepeatNumber(nums);
        System.out.println(result);
    }


    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int target = 0;
        for (int i= 0;i < nums.length;i++){
            if (!set.add(nums[i])){
                target = nums[i];
                return target;
            }
        }
        return target;
    }
}
