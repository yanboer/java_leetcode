package sort_algorithm.test;

import java.util.Arrays;



public class Heap_sort_bymyself {
    public static void main(String[] args) {
        int[] tree = new int[]{1,3,3,1,2,8,7,8,6,4,5,6,4,3};
        heap_sort(tree,tree.length);
        System.out.println(Arrays.toString(tree));
    }

    public static void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        for(int i = n - 1;i >= 0;i--){
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }

    public static void build_heap(int[] tree,int n){
        int start_position = (n - 1)/2;
        for(int i = start_position;i >= 0;i--){
            heapify(tree,n,i);
        }
    }

    public static void heapify(int[] tree,int n,int i){
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    public static void swap(int[] tree,int i,int max){
        int temp = tree[i];
        tree[i] = tree[max];
        tree[max] = temp;
    }

}
