package sort_algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arry = new int[]{1, 3, -3, 7, 3, 2, 4, 6, 8, -1, -19,3};

        MergeSort m = new MergeSort();

        m.merge_sort(arry,0,arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    //递归实现长数组的分割
    public void merge_sort(int[] arry, int left, int right) {
        int midle = (left + right) / 2;
        if (left < right) {
            merge_sort(arry, left, midle);                //对左半部分分割
            merge_sort(arry, midle + 1, right);       //对右半部分分割
            merge(arry, left, midle + 1, right);        //数组元素的升序合并
        }
    }

    /**
     * 用于数组元素的升序排序
     *
     * @param arry      需要分割的长数组
     * @param left      左半部分数组的首元素
     * @param midel     右半部分的首元素
     * @param right     右半部分的尾元素
     */
    public void merge(int[] arry,int left,int midel,int right){
        int l = left;       //左半部分首元素
        int r = midel;      //右半部分首元素

        int[] temp = new int[arry.length];      //临时数组
        int t = 0;      //临时数组的指针

        while (l <= midel - 1 && r <= right){
            if(arry[l] < arry[r]){                //比较左半部分和右半部分元素的大小，小的放入temp[] 中
                temp[t++] = arry[l++];
            } else if(arry[r] <= arry[l]){        //比较左半部分和右半部分元素的大小，小的放入temp[] 中
                temp[t++] = arry[r++];
            }
        }

        while (l <= midel - 1){              //左边数组未放完，将剩余元素放入   temp[]
            temp[t++] = arry[l++];
        }

        while (r <= right){              //右边数组未放完，将剩余元素放入   temp[]
            temp[t++] = arry[r++];
        }

        t = 0;
        //将 temp[] 复制到 arry1[]
        while (left <= right) {
            arry[left++] = temp[t++];
        }

    }
}
