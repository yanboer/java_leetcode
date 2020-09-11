package hard;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] a = new int[]{2,1,5,6,2,3};

        LargestRectangleArea l = new LargestRectangleArea();
        int result = l.largestRectangleArea(a);
        System.out.println(result);
    }
    //dp
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        if(size == 0){
            return 0;
        }
        /**
         f[i] 表示以 nums[i]为最右边的矩形最大面积
         例如：f[0] 表示吧 nums[0] 作为矩形最右边的矩形的最大面积
         i:  0 ~ size:
         j:  i ~ 0
         f[i] = Math.max(Math.min(nums[i] ~ nums[i - j]) * (i - j + 1))

         Math.min(nums[i] ~ nums[i - j])   ===> 矩形的高
         (i - j + 1)                       ===> 矩形的宽
         */
        int[] f = new int[size];
        f[0] = heights[0];
        for(int i = 1;i <= size - 1;i++){
            int minHeight = heights[i]; //获取 minHeight 最小值
            for(int j = i;j >= 0;j--){
                int wide = i - j + 1;       //矩形宽
                minHeight = Math.min(minHeight,heights[j]); //求矩形最小的高

                f[i] = Math.max(f[i],wide * minHeight);
            }
        }
        int result = 0; //结果
        for(int i = 0;i <= size - 1;i++){
            result = Math.max(result,f[i]);
        }
        return result;
    }
}
