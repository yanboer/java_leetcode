package pointer;
import java.util.*;
/**
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 *
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举（A[i]，A[j]，A[k]）：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * 示例 2：
 *
 * 输入：A = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * A[i] = 1，A[j] = A[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-with-multiplicity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumMulti {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,2,3,3,4,4,5,5,};
        int target = 8;

        ThreeSumMulti t = new ThreeSumMulti();
        int result = t.threeSumMulti(a,target);
        System.out.println(result);
    }
    //三指针
    /**
     一个指针指向 i
     另外两个双指针 从头到尾找 target - nums[i]
     */
    //long 存储 sum
    public int threeSumMulti(int[] A, int target) {
        int n = A.length;
        Arrays.sort(A);
        long sum = 0;    //结果
        for(int i = 0;i < n - 2;i++){
            int l = i + 1;
            int r = n - 1;   //右
            while(A[l] < A[r]){
                if(A[l] + A[r] == target - A[i]){
                    int left = l;
                    int right = r;
                    while(A[++l] == A[left]);       //找到不等于 A[left] 的下一个数(往后找)

                    while(A[--r] == A[right]);       //找到不等于 A[right] 的下一个数(往前找)
                    sum += (l - left) * (right - r);
                }
                else if(A[l] + A[r] > target - A[i]){
                    r--;
                }
                else if(A[l] + A[r] < target - A[i]){
                    l++;
                }
            }
            if(A[l] == A[r] && A[l] + A[r] == target - A[i]){   //C(2,n)
                int len = r - l + 1;
                long t = (long)len*(long)(len - 1)/2;
                sum += t;
            }
        }
        long res = sum%1000000007;
        return (int)res;
    }
}
