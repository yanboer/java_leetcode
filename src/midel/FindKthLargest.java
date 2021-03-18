package midel;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class FindKthLargest {
    /**
     1、排序后直接返回第 nums.length - k 元素
     2、根据快排思想
     3、根据堆
            1、建立 nums.length 大的最大堆，然后弹出 k 个元素
            2、建立 k 个元素的最小堆，然后新建元素进行比较，大于就替换掉堆顶元素，然后进行重建堆，最后堆顶就是 第 k 大
     */

    // 1、排序后直接返回第 nums.length - k 元素
    // public int findKthLargest(int[] nums, int k) {
    //     int n = nums.length;

    //     Arrays.sort(nums);
    //     return nums[n - k];
    // }

    static int n;
    static int result = -1;

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,5,6,4};
        int k = 2;
        int res = findKthLargest(test, k);
        System.out.println(res);
    }
    //2、根据快排思想
    // public static int findKthLargest(int[] nums, int k) {
    //     n = nums.length;

    //     quick_sort(nums,0,n - 1,k);
    //     return result;
    // }

    // public static int quick_sort(int[] arry,int L,int R,int k){
    //     int left = L;
    //     int right = R;
    //     int pivot = arry[left];
    //     while(left < right){
    //         while(left < right && arry[right] >= pivot){
    //             right--;
    //         }
    //         if(left < right && arry[right] < pivot){
    //             arry[left] = arry[right];
    //             left++;
    //         }
    //         if(left == right){
    //             arry[right] = pivot;
    //             break;
    //         }

    //         while(left < right && arry[left] <= pivot){
    //             left++;
    //         }
    //         if(left < right && arry[left] > pivot){
    //             arry[right] = arry[left];
    //             right--;
    //         }
    //         if(left == right){
    //             arry[right] = pivot;
    //             break;
    //         }
    //     }

    //     if(right > n - k){
    //         quick_sort(arry,L,right - 1,k);
    //     }
    //     if(right < n - k){
    //         quick_sort(arry,right + 1,R,k);
    //     }
    //     if(right == n - k){
    //         result = pivot;
    //         return pivot;
    //     }
    //     return -1;
    // }


    //3、根据堆
    public static int findKthLargest(int[] nums, int k) {
        n = nums.length;
        int res = heap_sort(nums,n,k);
        return res;
    }

    public static int heap_sort(int[] tree,int n,int k){
        build_heap(tree,n);
        int index = 0;

        for(int i = n - 1;i >= 0;i--){
            swap(tree,0,i);
            heapify(tree,i,0);
            index++;
            if(index == k){
                break;
            }
        }

        return tree[n - k];
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
            swap(tree,i,max);
            heapify(tree,n,max);
        }
    }

    public static void swap(int[] tree,int i,int max){
        int temp = tree[i];
        tree[i] = tree[max];
        tree[max] = temp;
    }
}
