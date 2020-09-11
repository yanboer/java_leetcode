package simple;

import java.util.*;
/**
 *
 *
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

     示例：

         输入：nums = [1,2,3,4]
         输出：[1,3,2,4]
         注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int[] result = exchange.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }
    public int[] exchange(int[] nums) {

        int[] half_a = new int[nums.length];
        int[] half_b = new int[nums.length];
        int[] target = new int[nums.length];

        int half_a_left = 0;
        int half_b_left = 0;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2 == 1){
                half_a[half_a_left] = nums[i];
                half_a_left++;
            }
            if(nums[i]%2 == 0){
                half_b[half_b_left] = nums[i];
                half_b_left++;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(half_a_left > i){
                target[i] = half_a[i];
            }
            else{
                target[i] = half_b[i - half_a_left];
            }
        }
        return target;
    }
}
