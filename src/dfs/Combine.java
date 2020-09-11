package dfs;

import java.util.*;
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> result = combine.combine(4, 2);
//        List<List<Integer>> result = combine.combine(10,7);

        for (List<Integer> temp_a :result) {
            for (Integer temp : temp_a) {
                System.out.println(temp);
            }
            System.out.println("==========");
        }
    }


    Set<Set<Integer>> setSet = new HashSet<>();    //结果集
    boolean[] color = null;

    public List<List<Integer>> combine(int n, int k) {

        color = new boolean[n+1];

        dfs(0,n,k,new HashSet<Integer>());

        List<List<Integer>> listList = new LinkedList<>();

        for(Set<Integer> temp:setSet){      //setSet 转化为 listList
            List<Integer> list = new LinkedList<>(temp);
            listList.add(list);
        }
        return listList;
    }

    public void dfs(int n,int num,int k,Set<Integer> set){
        if(n == k){     //符合条件
            for(Set<Integer> temp:setSet){
                if (temp.equals(set)){      //重复就直接返回
                    return;
                }
            }
            setSet.add(new HashSet<Integer>(set));
            return;
        }
        else{
            for(int i = 1;i<=num;i++){
                if(!color[i]){
                    color[i] = true;
                    set.add(i);        //添加到 list

                    dfs(n+1,num,k,set);    //继续遍历

                    set.remove(Integer.valueOf(i));       //回溯     ---- 选择指定值去掉，因为该序列不可能有重复元素
                    color[i] = false;
                }
            }
        }
    }
}
