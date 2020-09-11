package dfs;
import java.util.*;
/**
 *      1、dfs 求解
 *      2、滑动窗口求解    slider window
 */


/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] result = findContinuousSequence.findContinuousSequence(9);
        for(int i = 0;i <= result.length - 1;i++){
            for(int j = 0;j <= result[i].length - 1;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
    // List<List<Integer>> listList = new LinkedList<>();  //结果
    // //dfs
    // public int[][] findContinuousSequence(int target) {

    //     for(int i = 1;i <= target;i++){
    //         dfs(i,target,new LinkedList<Integer>());
    //     }

    //     // for(List<Integer> list:listList){
    //     //     System.out.println(list);
    //     // }
    //     int[][] result = new int[listList.size()][];

    //     for (int i = 0; i <= listList.size() - 1; i++) {
    //         int size = listList.get(i).size();
    //         result[i] = new int[size];
    //         for (int j = 0; j <= size - 1; j++) {
    //             result[i][j] = listList.get(i).get(j);
    //         }
    //     }

    //     return result;
    // }
    // public void dfs(int start,int target,List<Integer> list){
    //     if(calSum(list) == target && list.size() > 1){       //满足条件
    //         listList.add(list);
    //         return;
    //     }
    //     if(calSum(list) > target){   //大于
    //         return;
    //     }

    //     list.add(start);                    //添加
    //     dfs(start + 1,target,list);         //递归
    // }

    // //求集合的和        等差数列求和公式
    // public int calSum(List<Integer> list){
    //     int sum = 0;
    //     if(list.size() == 1){
    //         sum = list.get(0);
    //     }
    //     else if(list.size() > 1){
    //         sum = (list.get(0) + list.get(list.size() - 1)) * list.size()/2;
    //     }
    //     return sum;
    // }

    //滑动窗口求解  ---》slider window      ---》左右边界只能向右移动
    public int[][] findContinuousSequence(int target) {

        List<List<Integer>> listList = new LinkedList<>();    //结果

        int left = 1;   //左窗口边界
        int right = 2;  //右窗口边界
        int sum = left + right;
        while(left < target){  //左边界 <= target
            if(sum == target){  //一个结果
                List<Integer> list = new LinkedList<>();
                for(int i = left;i <= right;i++){
                    list.add(i);
                }
                listList.add(list);     //添加到 listList

                sum -= left;            //和减去 left
                left = left + 1;        //左指针右移动
            }
            if(sum < target){   //小于
                right = right + 1;        //右指针右移动
                sum += right;       //和加上新的 right
            }
            if(sum > target){
                sum -= left;            //和减去 left
                left = left + 1;        //左指针右移动
            }
        }

        int[][] result = new int[listList.size()][];

        for (int i = 0; i <= listList.size() - 1; i++) {
            int size = listList.get(i).size();
            result[i] = new int[size];
            for (int j = 0; j <= size - 1; j++) {
                result[i][j] = listList.get(i).get(j);
            }
        }

        return result;
    }
}
