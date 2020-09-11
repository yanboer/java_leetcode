package simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *      输入: 123
 *      输出: 321
 */
public class Reverse {


    public static void main(String[] args) {

        int a = 123;
        int b = -123;
        int c = 90000;
        int d = 1534236469;
        Reverse reverse = new Reverse();
        int result = reverse.reverse(d);
        System.out.println("result:" + result);
    }

    public int reverse(int x) {
        boolean flag = false;
        if (x < 0){
            flag = true;
        }
        int leng = Integer.toString(Math.abs(x)).length();
        System.out.println("数字长度为：" + leng);
        int tag = leng;
        int[] target = new int[leng];
        double result = 0;
        for(int i = 0;i < tag ;i++){
            target[i] = Math.abs(x)%10;
        result = target[i] * Math.pow(10,leng - 1) + result;
        leng--;
        System.out.println("result :"+result);
        x = Math.abs(x)/10;
    }
        for (int i = 0; i < target.length; i++) {
            System.out.println(target[i]);
        }
        System.out.println(result);
        if (result > Math.pow(2,31) - 1 || result < -1 * Math.pow(2,31) )
        {
            return 0;
        }
        if (flag){
            return (int)result * -1;
        }
        return (int)result;
    }
}
