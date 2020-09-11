package simple;

/**
 * 暴力循环
 */
public class CountDigitOne {
    public static void main(String[] args) {

        CountDigitOne countDigitOne = new CountDigitOne();
        int result = countDigitOne.countDigitOne(113);
        System.out.println(result);
    }
    public int countDigitOne(int n) {
        int onenum = 0;
        for(int i = 1;i <=n;i++){
            onenum = onenum +countOne(i);
        }
        return onenum;
    }
    public int countOne(int n){     //计算一个数字中 1 出现的次数
        int num = 0;    //该数字中1出现次数

        while(n != 0){
            if(n%10 == 1){
                num++;
            }
            n = n/10;
        }
        return num;

    }
}
