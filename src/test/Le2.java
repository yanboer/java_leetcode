package test;

import org.junit.Test;

import java.util.Arrays;

public class Le2 {
    @Test
    public void test(){
        int[] a = {1,1,1,2,3,4};

        int[] res = numsGame(a);
        System.out.println(Arrays.toString(res));
    }
    public int[] numsGame(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(nums[0] + 1 - nums[1]) + dp[0];
        for(int i = 2;i < n;i++){
            int val = Math.abs(nums[i - 1] + 1 - nums[i]);
            nums[i] = nums[i - 1] + 1;
            dp[i] = dp[i - 1] + val;
        }

        return dp;
    }
    @Test
    public void test1(){
        int r = xwbak(888);
        System.out.println(r);
    }

    public int xwbak(int tab){
        int n = tab;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n;
    }
}
