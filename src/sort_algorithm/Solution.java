package sort_algorithm;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] num = {100,10,20,70,60,10,50};
        int target = 80;

        ArrayList<ArrayList<Integer>> list = solution.combinationSum2(num, target);

        System.out.println(Arrays.toString(list.toArray()));
    }


    Set<ArrayList<Integer>> set = new HashSet<>();

    boolean[] color;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        int n = num.length;
        color = new boolean[n];

        Arrays.sort(num);
        dfs(0,num,new LinkedList<Integer>(),target);

        return new ArrayList<>(set);
    }

    public void dfs(int start,int[] num,List<Integer> list,int target){
        int sum = 0;
        for(int i = 0;i < list.size();i++){
            sum += list.get(i);
        }

        if(sum == target){
            set.add(new ArrayList<>(list));
        }
        if(sum > target){
            return;
        }
        for(int i = start;i < num.length;i++){
            if(i > 0 && color[i - 1] == false && num[i] == num[i - 1]){
                continue;
            }
            if(color[i] == true){
                continue;
            }
            color[i] = true;
            list.add(num[i]);
            dfs(i + 1,num,list,target);
            list.remove(list.size() - 1);
            color[i] = false;
        }
    }
}
