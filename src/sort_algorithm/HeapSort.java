package sort_algorithm;

import java.util.Arrays;

/**
 *  1、建堆
 *  2、排序
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort h = new HeapSort();

//        int[] tree = new int[]{4,10,3,5,1,2};
        int[] tree = new int[]{2,5,3,1,10,4};
        int n = tree.length;
//        h.heapify(a,n,0);
//        System.out.println(Arrays.toString(a));
        h.heap_sort(tree,n);

        System.out.println(Arrays.toString(tree));


    }

    //堆排序
    public void heap_sort(int[] tree,int n){
        build_heap(tree,n);     //建立大顶堆
        for(int i = n - 1;i >= 0;i--){
            swap(tree,0,i);     //交换根节点(最大值)和尾结点
            heapify(tree,i,0);     // 从 i 开始，相当于砍掉了尾结点(最大值)
        }
    }

    /**
     * 建堆
     * @param tree  数组
     * @param n     数组长度
     */
    public void build_heap(int[] tree,int n){
        for(int i = (tree.length - 1)/2;i >= 0;i--){       //从最后一个节点的父节点开始，倒着做 heapify(建立大顶堆)
            heapify(tree,n,i);
        }
    }


    /**
     *      找出一个局部树的最大值
     * @param tree      //待排序数组
     * @param n         //数组长度
     * @param i         //parent 节点
     */
    public void heapify(int[] tree,int n,int i){
        if(i >= n){     //递归出口
            return;
        }
        int c1 = 2 * i + 1;     // i 的第一个子节点
        int c2 = 2 * i + 2;     // i 的第二个子节点
        int max = i;    //假设最大值为 i 时的值
        if(c1 < n && tree[c1] > tree[i]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){       //最大值不是 i(parent) 节点
            swap(tree,max,i);   //交换 tree 中的 max 和 i 节点
            heapify(tree,n,max);    //对 max 节点继续 heapify
        }
    }

    //交换 max 和 i 节点
    private void swap(int[] tree, int max, int i) {
        int temp = tree[max];
        tree[max] = tree[i];
        tree[i] = temp;
    }
}
