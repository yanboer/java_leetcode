package sort_algorithm;

import java.util.Arrays;

/**
 *      Arrays.sort(nums[]) 可以直接对数组进行升序排序
 *      Arrays.sort(nums[],fromindex,toindex);      对指定数组的 [fromindex,toindex)区间元素排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 67, 78, 9, 90, 6, 3, 2};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
        Arrays.sort(a, 3, 6);
        System.out.println(Arrays.toString(a));
    }
}
