package sort_algorithm;

import java.util.*;

/**
 *       在 n 个正整数中，任意挑选 k 个(不可重复挑选，0<=k<=n)数字和记为 sum，另有一个正整数 m，请问 sum%m 最大是多少？
 *
 *       输入：
 *          第一行两个正整数 n,m
 *          第二行 n 个正整数
 *       输出：
 *          一个数 x，表示 sum%m 最大值。
 *
 *
 *       示例：
 *          输入：
 *              5 5
 *              1 2 3 4 5
 *          输出：
 *              4
 *
 */
public class Sum_delivery_m {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

    }

    public int cal(int[] nums,int m){

        Arrays.sort(nums);      //对数组进行排序
        int target = 0;     //存储结果
        int sum = 0;        //存储和
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){

            }

        }
        return 0;
    }
}
