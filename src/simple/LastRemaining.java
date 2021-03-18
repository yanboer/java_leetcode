package simple;

import java.util.ArrayList;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 约瑟夫环
 */
public class LastRemaining {
    //模拟过程
    // public int lastRemaining(int n, int m) {
    //     ArrayList<Integer> list = new ArrayList<>(n);
    //     for(int i = 0;i < n;i++){
    //         list.add(i);
    //     }
    //     int index = 0;
    //     while(n > 1){
    //         index = (index + m - 1)%n;
    //         list.remove(index);
    //         n--;
    //     }

    //     return list.get(0);
    // }

    //递归
    public int lastRemaining(int n, int m){
        if(n < 1 || m < 1)
            return -1;
        if(n == 1)
            return 0;
        return (lastRemaining(n - 1,m) + m) % n;
    }
}
