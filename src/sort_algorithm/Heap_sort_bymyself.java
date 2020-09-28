package sort_algorithm;

import java.util.Arrays;

public class Heap_sort_bymyself {
    public static void main(String[] args) {
        Heap_sort_bymyself h = new Heap_sort_bymyself();

        int[] tree = new int[]{4,5,3,4,7,8,9,1,85,0,-5,4,-3,4,-4,0};
        int n = tree.length;
        h.heap_sort(tree,n);

        System.out.println(Arrays.toString(tree));
    }


    /**
     *
     * @param tree  待排序数组
     * @param n     长度
     */
    public void heap_sort(int[] tree,int n){
        buile_tree(tree,n);                 //构建大顶堆
        for(int i = n - 1;i >= 0;i--){      //从最后一个节点开始进行排序(堆顶元素与堆尾元素)
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }

    //构建大顶堆
    public void buile_tree(int[] tree,int n){
        int start_position = (n - 1)/2;     //最后一个叶子节点的父节点
        for(int i = start_position;i >= 0;i--){     //从最后一个叶子节点的父节点 开始进行大顶堆构建
            heapify(tree,n,i);
        }
    }
    /**
     *
     * @param tree  待排序数组
     * @param n     数组长度
     * @param i     对第 i 个节点进行 建立大顶堆
     */
    public void heapify(int[] tree,int n,int i){
        if(i >= n){         //递归出口
            return;
        }
        int c1 = 2 * i + 1;     // i 节点的左孩子节点
        int c2 = 2 * i + 2;     // i 节点的右孩子节点
        int max = i;
        if(c1 < n && tree[c1] > tree[i]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){ //注意是 tree[max]
            max = c2;
        }
        if(max != i){       //该小堆不是大顶堆
            swap(tree,max,i);           //交换位置(最大值节点和根节点)
            heapify(tree,n,max);        //递归进行
        }
    }

    private void swap(int[] tree, int max, int i) {
        int temp = tree[max];
        tree[max] = tree[i];
        tree[i] = temp;
    }
}
