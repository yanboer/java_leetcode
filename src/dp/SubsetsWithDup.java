package dp;
import java.util.*;
/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> result = subsetsWithDup.subsetsWithDup(a);

        for(List<Integer> temp : result){
            for(int temp_a:temp){
                System.out.println(temp_a);
            }
        }
    }

    List<List<Integer>> listList = new LinkedList<>();  //结果集

    boolean[] color = null;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<Integer> list = new LinkedList<>();
        color = new boolean[nums.length];

        listList.add(list);     //添加空集

        Arrays.sort(nums);      //升序排序

        if(nums.length == 0){
            return listList;
        }

        dfs(nums,list,0);

        return listList;
    }

    public void dfs(int[] nums,List<Integer> list,int start){    //start:开始位置
        if(list.size() > 0){      //list 不为空
            listList.add(new LinkedList<>(list));
        }

        for(int i = start;i <= nums.length - 1;i++){
            //去重思路：重复的起点或重复的第 i 个元素会导致重复的遍历结果，所以对 nums 排序后，后面元素如果与前面元素相同，则从后面元素开始走时会产生重复排列结果
            if (i > 0 && nums[i] == nums[i - 1] && color[i - 1] == false) {
                continue;
            }
            color[i] = true;        //标记
            list.add(nums[i]);      //添加元素
            dfs(nums,list,i + 1);       //继续遍历
            list.remove(list.size() - 1);       //回溯
            color[i] = false;
        }
    }
}
