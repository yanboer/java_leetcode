package sort_algorithm;

/**
 * 二分搜索
 */
public class Half_Search {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 10, 11, 15, 20};
        int target = 20;

        Half_Search half_search = new Half_Search();
        int result = half_search.half_search(nums, target);
        System.out.println(result);
    }

    public int half_search(int[] nums,int target){
        int left = 0;           //左边指针
        int right = nums.length -  1;           //右边指针
        int index = 0;      //要查的数据的下标
        while (left <= right){

            int midel = (left + right)/2;           //中间指针（每次 left 、right变化 midel都需要变化，所以需要定义在循环体内）

            if (target > nums[midel]){
                left = midel + 1;
            }
            if (target < nums[midel]){
                right = midel - 1;
            }
            if (target == nums[midel]){
                index = midel;
                return index;
            }
        }
        return index;
    }
}
