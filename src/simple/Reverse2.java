package simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *      输入: 123
 *      输出: 321
 */
public class Reverse2 {


    public static void main(String[] args) {

        int a = 123;
        int b = -123;
        int c = 90000;
        int d = 1534236469;
        Reverse2 reverse = new Reverse2();
        int result = reverse.reverse(d);
    }

    public int reverse(int x) {

        long temp = 0;      //需要判断溢出，所以使用 long
        while (x != 0) {        // x = x /10  = 0; 上一步x < 10
            temp = temp * 10 + x % 10;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;

        }

        return (int)temp;
    }
}
