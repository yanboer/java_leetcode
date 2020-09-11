package dfs;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 *      list 排序：
 *              Collections.sort(list, new Comparator<Integer>() {          //排序
 *                 @Override
 *                 public int compare(Integer o1, Integer o2) {
 *                     return o1.compareTo(o2);
 *                 }
 *             });
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
//        int[] a = new int[]{10,1,2,7,6,1,5};
        int[] a = new int[]{1,1};
        List<List<Integer>> result = combinationSum2.combinationSum2(a, 2);


        for (List<Integer> temp_a :result) {
            for (Integer temp : temp_a) {
                System.out.println(temp);
            }
        }

    }


    List<List<Integer>> listList = new LinkedList<>();      //存储结果集
    boolean[] color = null;     //标记

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(target == candidates[0] && candidates.length == 1){        //特殊情况特殊考虑
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(candidates[0]);
            listList.add(temp);
        }


        color = new boolean[candidates.length];

        dfs(0,candidates,target,new LinkedList<>(),0);

        return listList;
    }

    public void dfs(int n,int[] candidates,int target,List<Integer> list,int sum){
        for(int i = 0;i<list.size();i++){
            sum += list.get(i);
        }
        if(sum == target && n <= candidates.length){     //符合条件加入结果集

            Collections.sort(list, new Comparator<Integer>() {          //排序
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            for (List<Integer> temp : listList) {                   //去重
                if (temp.equals(list)){
                    return;
                }
            }

            listList.add(new LinkedList<>(list));
        }

        else{
            for(int i = 0;i<candidates.length;i++){
                if(sum<=target&&!color[i]){        //剪枝判断
                    color[i] = true;
                    list.add(candidates[i]);        //选中
                    dfs(n+1,candidates,target,list,0);      //继续遍历 ---》因为不能重复，所以是 n+1
                    list.remove(Integer.valueOf(candidates[i]));        //回溯
                    color[i] = false;
                }
            }
        }
    }
}
