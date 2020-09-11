package simple;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Permute {
    public static void main(String[] args) {

        Permute permute = new Permute();
        List<List<Integer>> result = permute.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

    boolean[] color = null;
    List<List<Integer>> listList = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        color = new boolean[nums.length];

        dfs(0,nums,list);

        return listList;
    }

    public void dfs(int n,int[] nums,List<Integer> list){
        if(list.size() == nums.length){

            listList.add(new LinkedList<>(list));         //变量问题
//            listList.add(list);                     //错误 ❎        最终加到的都是 list 数组，如果list数组发生改变，则所有加入的到listList的都会改变
            return;
        }
        else{
            for(int i=0;i< nums.length;i++){
                if(!color[i]){
                    color[i] = true;
                    list.add(nums[i]);
                    dfs(n+1,nums,list);
                    list.remove(Integer.valueOf(nums[i]));          //remove 移除对象只能是 Object
                    color[i] = false;
                }
            }
        }
    }

}