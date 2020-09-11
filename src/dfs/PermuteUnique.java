package dfs;

import java.util.*;
/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();

        int[] a = new int[]{2,2,1,1};
//        int[] a = new int[]{1,1,2};
        List<List<Integer>> result = permuteUnique.permuteUnique(a);

        for (List<Integer> temp_a :result) {
            for (Integer temp : temp_a) {
                System.out.println(temp);
            }
            System.out.println("==========");
        }

    }

    List<List<Integer>> listList = new LinkedList<>();     //结果集

    boolean[] color = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        color = new boolean[nums.length];

        dfs(0,nums,new LinkedList<Integer>());

        return listList;
    }

    public void dfs(int n,int[] nums,List<Integer> list){
        if(list.size() == nums.length){     //符合条件

            for(List<Integer> temp:listList){       //去重
                if(temp.equals(list)){
                    return;
                }
            }

            listList.add(new LinkedList<>(list));       //添加到集合中
            return;
        }
        else{
            for(int i = 0;i<nums.length;i++){
                if(!color[i]){      //剪枝判断
                    color[i] = true;    //标记
                    list.add(nums[i]);

                    dfs(n+1,nums,list);     //遍历
                    //错误，因为当 1 2 2 1 的情况时，回溯最后一个添加的1时，会导致 list 删除首位的1，因此需要指定位置删除
//                    list.remove(Integer.valueOf(nums[i]));
                    list.remove(list.size() - 1);  //回溯
                    color[i] = false;
                }
            }
        }
    }
}
