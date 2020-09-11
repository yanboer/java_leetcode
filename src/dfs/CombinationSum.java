package dfs;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
//        int[] a = new int[]{2,3,6,7};
        int[] a = new int[]{2,3,5};
        List<List<Integer>> result = combinationSum.combinationSum(a, 8);


        for (List<Integer> temp_a :result) {
            for (Integer temp : temp_a) {
                System.out.println(temp);
            }
        }
    }

    List<List<Integer>> listList = new LinkedList<List<Integer>>(); //结果集

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0,candidates,target,new LinkedList<Integer>(),0);   //sum 记录 list之和

        return listList;
    }

    public void dfs(int n,int[] candidates,int target,List<Integer> list,int sum){
        for(int i = 0;i<list.size();i++){
            sum += list.get(i);
        }
        if(n<candidates.length&&target == sum){      //符合结果就加入 listList 中
            //1、排序
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            //2、去重
            for (List<Integer> temp : listList) {
                if (temp.equals(list)){
                    return;
                }
            }

            listList.add(new LinkedList<>(list));
        }
        else{
            for (int i = 0; i < candidates.length; i++) {       //从 n 开始找
                    if(sum <= target){       //剪枝判断
                        list.add(candidates[i]);        //添加选中元素
                        dfs(n,candidates,target,list,0);        //继续遍历      -----》只能是 n ，不能是 n + 1，
                        list.remove(Integer.valueOf(candidates[i]));     //回溯
                    }
                }
        }
    }
}
