package midel;

/**
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *
 *      示例 1：
 *
 *          输入：n = 3
 *          输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 未完成
 */
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        findNthDigit.findNthDigit(3);
    }
    public int findNthDigit(int n) {
        int num_digits = 0;     //数字 n 的位数
        int number = 0;         //数字 n 的数字数量
        int num_digits_count = 0;       //数位数量
        while(n > num_digits_count){
            num_digits += 1;
            number += 9 * (Math.pow(10,num_digits - 1));
            num_digits_count += num_digits * number;
        }
        int result = number + num_digits_count/num_digits;
        System.out.println(result);
        int yushu = num_digits_count%num_digits;        //余数

        int[] target =  new int[(String.valueOf(result)).length()];


        return result;
    }
}
