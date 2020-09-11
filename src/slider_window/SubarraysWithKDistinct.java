package slider_window;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,1,2,3};

        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        int result = subarraysWithKDistinct.subarraysWithKDistinct(A,2);
        System.out.println(result);
    }
    int good_num = 0;   //好子数组数量

    //slider window
    public int subarraysWithKDistinct(int[] A, int K) {
        int left = 0;   //左窗口
        int right = 0;  //右窗口

        int sum = 1;    //不同整数个数


        while(left <= A.length - K && right <= A.length - 1 && left <= right){    //剩余数组数量大于 K
            if(sum == K){   //符合要求
                good_num++;        //好子数组数量 + 1

                if(right >= A.length - 1){      //越界      ===》之后 right + 1 会有越界的可能
                    break;
                }
                right = right + 1;    //右窗口右移(可能之后元素重复，sum 不会变大)
                int temp1 = A[right];

                if(checkNum(A,left,right - 1,temp1)){      //在
                    sum = sum;
                }
                if(!checkNum(A,left,right - 1,temp1)){     //不在
                    sum += 1;
                }
                continue;       //进行一次 sum 的操作后需要重新进行 sum 的判断和操作
            }

            if(sum < K){    //小于 K
                if (right >= A.length - 1){
                    break;
                }
                right = right + 1;  //右窗口右移动
                int temp2 = A[right];

                if(checkNum(A,left,right - 1,temp2)){      //在
                    sum = sum;
                }
                if(!checkNum(A,left,right - 1,temp2)){     //不在
                    sum += 1;
                }
                continue;
            }

            if(sum > K){    //大于 K
                int temp3 = A[left];
                left = left + 1;        //左窗口右移

                if(checkNum(A,left,right,temp3)){      //在
                    sum = sum;
                }
                if(!checkNum(A,left,right,temp3)){     //不在
                    sum -= 1;
                }
                continue;
            }
        }

        return good_num;
    }

    //判断 target 在不在 nums 中
    public boolean checkNum(int[] nums,int left,int right,int target){
        boolean flag = false;
        for(int i = left;i <= right;i++){
            if (target == nums[i]){
                flag = true;
            }
        }

        return flag;
    }
}
