package dfs;

import java.util.*;
/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetPermutation {
    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
//        String result = getPermutation.getPermutation(3, 3);
        String result = getPermutation.getPermutation(4,9);

        System.out.println("结果为："+result);
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0;i<nums.length;i++){       //初始化    ====> 第 1 个排列
            nums[i] = i+1;
        }

        for(int i = 1;i<k;i++){
            next_num(nums);
        }

        String result = "";
        for(int i = 0;i<nums.length;i++){
            result += ""+nums[i];
        }

        return result;
    }

    public int[] next_num(int[] nums){      //寻找给定数组的下一个排列
        for(int i = nums.length - 2;i>=0;i--){
            for(int j = nums.length - 1;j>i;j--){
                if(nums[i]<nums[j]){        //后面找到了比前面大的
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums,i+1,nums.length);
                    return nums;
                }
            }
        }
        return nums;
    }
}
