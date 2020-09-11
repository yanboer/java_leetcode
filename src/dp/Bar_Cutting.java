package dp;

/**
 * 钢条切割：
 * 长度：1    2   3   4   5   6   7   8   9   10
 * 价格：1    5   8   9   10  17  17  20  24  30
 * <p>
 * 给定长度为 n 的钢条，和价格表，求钢条切割方案使得收益最大！(若 n 时收益最大，则不切割就可以了！)
 */
public class Bar_Cutting {
    public static void main(String[] args) {
        int[] price = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};    //price[n]表示长度为 n 时的钢条价格

        Bar_Cutting bar_cutting = new Bar_Cutting();
        int result = bar_cutting.bar_cutting(price, 10);
        System.out.println(result);
    }


    public int bar_cutting(int[] price, int length) {

        int income[] = new int[length + 1];     // income[n] 代表 钢条长度为 n 时的最大收益
        int result = cacult(income, price, length);

        return result;
    }


    private int cacult(int[] income, int[] price, int length) {
        if (income[length] != 0) {
            return income[length];
        } else {
            if (length == 0) {
                return income[0];
            }
            if (length >= 1) {
                for (int i = 1; i < length + 1; i++) {
                    //最大收益为 n 时的最大收益 || 长度为 i 时的价格 + 剩下 n - i 长度的最佳收益
                    income[length] = Math.max(income[length], price[i] + cacult(income, price, length - i));
                }
            }
        }
        return income[length];
    }
}
