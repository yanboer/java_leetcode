package sort_algorithm.test;


import java.util.Arrays;

public class QuickQueryTest {
    public static void main(String[] args) {
        int[] arry = new int[]{1,10,3,5,3,4,7,8,9,2};
        quick_sort(arry,0,arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    public static void quick_sort(int[] arry,int L,int R){
        int left  = L;
        int right = R;

        int pivot = arry[left];

        while (left < right){
            while (left < right && arry[right] >= pivot){
                right--;
            }
            if(left < right && arry[right] < pivot){
                arry[left] = arry[right];
                left++;
            }
            if(left == right){
                arry[left] = pivot;
                break;
            }
            while (left < right && arry[left] <= pivot){
                left++;
            }
            if(left < right && arry[left] > pivot){
                arry[right] = arry[left];
                right--;
            }
            if(left == right){
                arry[left] = pivot;
                break;
            }
        }
        if(L < right){
            quick_sort(arry,L,right);
        }
        if(right + 1 < R){
            quick_sort(arry,right + 1,R);
        }
    }

}
