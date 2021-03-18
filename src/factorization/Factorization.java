package factorization;

import java.util.*;

/**
 *  给一个正数N，求这个N的所有的因子分解；
 *      N = 12；
 *      Ans = {12},{6,2},{3,4},{3,2,2}
 */
public class Factorization {
    static List<List<Integer>> res = new LinkedList<>();

    static Set<Integer> set = new HashSet<>();

    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        cal(n);

        System.out.println(Arrays.toString(res.toArray()));
    }

    public static void cal(int n){
        for(int i = 1;i <= n;i++){
            if(n % i == 0){
                list.add(i);
            }
        }
    }
}
