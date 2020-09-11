package sort_algorithm;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *      Arrays.sort(nums[]) 可以直接对数组进行升序排序
 *      Arrays.sort(nums[],fromindex,toindex);      对指定数组的 [fromindex,toindex)区间元素排序
 */
public class NextPermutation {
    public static void main(String[] args) {

        NextPermutation nextPermutation = new NextPermutation();

//        int[] nums = new int[]{1,2,4,7,8,1,0};
        int[] nums = new int[]{1, 3, 2};
//        int[] nums = new int[]{2,3,1};
//        int[] nums = new int[]{1,2,3};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 2; i >= 0; i--) {        //从倒数第二个数开始找后面比它大的数
            for (int j = nums.length - 1; j > i; j--) {     //找到的数就是比 nums[i] 大的最小的数
                // nums[j] 即是大于 nums[i] 的第一个数(因为之前没有找到降序序列，所以 索引 i 之后的数是降序排列的(正序)，所以nums[j] 即是大于 nums[i] 的第一个数)
                if (nums[i] < nums[j]) {
                    int temp = 0;
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);

    }


}
