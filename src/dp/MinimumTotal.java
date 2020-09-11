package dp;

import java.util.*;
/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal {
    public static void main(String[] args) {

        List<List<Integer>> listList = new LinkedList<>();

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new LinkedList<>();
        List<Integer> list4 = new LinkedList<>();

        list1.add(2);

        list2.add(3);
        list2.add(4);

        list3.add(6);
        list3.add(5);
        list3.add(7);

        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

//        list1.add(1);
//        list2.add(2);
//        list2.add(3);


        listList.add(list1);
        listList.add(list2);
        listList.add(list3);
        listList.add(list4);

//        System.out.println(listList.get(0).get(0));     //2
//        System.out.println(listList.size());    //4

        MinimumTotal minimumTotal = new MinimumTotal();
        int result = minimumTotal.minimumTotal(listList);
        System.out.println(result);

    }


    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle.size() == 1){       //特殊情况特殊处理
            return triangle.get(0).get(0);
        }

        //dp[i][j] 表示到顶层到 (i,j) 的最短路径
        // dp[i][j] = Math.min(dp[i - 1][j - 1] + value[i][j],dp[i - 1][j] + value[i][j]);
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < triangle.size(); i++) {       //初始化最大值，比较的时候能够取到最小值
            Arrays.fill(dp[i], 100000);
        }

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);       //初始化每一行的第一个(该行只有一条路可以走)
            for (int j = 1; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + triangle.get(i).get(j), dp[i - 1][j - 1] + triangle.get(i).get(j));
            }
        }

        int result = 100000;     //结果

        for(int i = 0;i<triangle.size();i++){
            result = Math.min(dp[triangle.size() - 1][i],result);
        }

        return result;
    }


}
