package test;

import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //表示 n 个月
        long res = fib(n);
        System.out.println(res);

    }
    public static long fib(int n) {
        long[] arry = new long[n + 1];
        arry[0] = 1;
        arry[1] = 1;
        for(int i =2;i<=n;i++){
            arry[i] = arry[i-1] + arry[i-2];
        }
        return arry[n];
    }
}
