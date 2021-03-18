package sort_algorithm;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickQuery {
    public static void main(String[] args) {
        QuickQuery q = new QuickQuery();

        int[] arry = new int[]{1, -1, 7, 3, 8, -7, 2, 4, 1};
        int L = 0;
        int R = arry.length - 1;

        q.quick_sort(arry,L,R);

        System.out.println(Arrays.toString(arry));
    }

    public int[] quick_sort(int[] arry,int L,int R){

        int left = L;
        int right = R;

        int pivot = arry[left];     //选取最左边为 pivot

        while (left < right){
            while (left < right && arry[right] >= pivot){       //右边 >= pivot   => 满足条件
                right--;
            }
            if(left < right && arry[right] < pivot){    //右边 < pivot   => 不满足条件
                arry[left] = arry[right];   //右边值给左边
                left++;
            }
            if(left == right){          //左边与右边重合了
                arry[left] = pivot;
                break;
            }
            while (left < right && arry[left] <= pivot){      //左边 <= pivot  =>满足条件
                left++;
            }
            if(left < right && arry[left] > pivot){      //左边 > pivot  =>不满足条件
                arry[right] = arry[left];
                right--;
            }
            if(left == right){          //左边与右边重合了
                arry[left] = pivot;
                break;
            }
        }

        if(right - 1 > L){
            quick_sort(arry,L,right - 1);
        }
        if(R > right + 1){
            quick_sort(arry,right + 1,R);
        }

        return arry;
    }
}
