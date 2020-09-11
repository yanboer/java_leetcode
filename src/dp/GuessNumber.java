package dp;

/**
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * -1 : 你猜测的数字比系统选出的数字大
 *  1 : 你猜测的数字比系统选出的数字小
 *  0 : 恭喜！你猜对了！
 *  
 *
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GuessNumber {

    int pick = 6;
    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        int result = guessNumber.guessNumber(10);
        System.out.println(result);
    }
    public int guessNumber(int n) {

        int start = 1;
        int end = n;

        int middle = 0;
        while(start<=end){
            // middle = (start + end)/2;    //会越界导致答案错误，不能这样写
            //middle = start/2 + end/2;     //当 pick = 1，n = 1 时会导致错误，不能这样写
            middle = start + (end - start)/2;
            if(guess(middle) == 0){
                return middle;
            }
            if(guess(middle) == -1){
                end = middle - 1;
            }
            if(guess(middle) == 1){
                start = middle + 1;
            }
        }

        return middle;
    }

    public int guess(int num){
        if (this.pick > num){
            return 1;
        }
        if (this.pick < num){
            return -1;
        }
        if (this.pick == num){
            return 0;
        }

        return 0;
    }
}
