package sort_algorithm.test;

import java.util.Arrays;

public class MergeSort_Test {
    public static void main(String[] args) {
        int[] arry = new int[]{1,3,3,1,2,8,7,8,6,4,5,6,4,3};
        merge_sort(arry,0,arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    public static void merge_sort(int[] arry,int L,int R){
        int midel = (L + R)/2;
        if(L < R){
            merge_sort(arry,L,midel);
            merge_sort(arry,midel + 1,R);
            merge(arry,L,midel + 1,R);
        }
    }

    private static void merge(int[] arry, int L, int M, int R) {
        int left = L;
        int right = M;

        int[] temp = new int[arry.length];
        int t = 0;

        while (left <= M - 1 && right <= R){
            if(arry[left] <= arry[right]){
                temp[t++] = arry[left++];
            } else {
                temp[t++] = arry[right++];
            }
        }

        while (left <= M - 1){
            temp[t++] = arry[left++];
        }

        while (right <= R){
            temp[t++] = arry[right++];
        }

        t = 0;
        while (L <= R){
            arry[L++] = temp[t++];
        }
    }
}
