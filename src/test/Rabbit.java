package test;
/**
 * 兔子问题:已知一对兔子每一个月可以生一对小兔子，而一对兔子出生后.第二个月开始生小兔子,假如没有发生死亡，则第 n 个月有多少兔子？
 */

import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //表示 n 个月

        long[] arry = new long[n + 1];
        arry[0] = 1;
        arry[1] = 1;
        for(int i =2;i<=n;i++){
            arry[i] = arry[i-1] + arry[i-2];
        }

        System.out.println(arry[n]);
    }
}
