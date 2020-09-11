package simple;

/**
 * 未完成
 */
public class CountDigitOne2 {
    public static void main(String[] args) {

        CountDigitOne2 countDigitOne = new CountDigitOne2();
        int result = countDigitOne.countDigitOne(13);
        System.out.println(result);
    }
    public int countDigitOne(int n) {
        double sum = 0;
        String target = String.valueOf(n);  //转换成字符串
        int length = target.length();       //一共几位
        int[] arry = new int[length];       //存储每位数字

        for (int i = 0; i < length; i++) {
            arry[i] = Integer.parseInt(target.substring(i,i+1));
        }
//        for (int i = 0; i < length; i++) {
//            System.out.println(arry[i]);
//        }

        for (int i = 0; i < length; i++) {
            if (arry[i] > 1){
                sum += Math.pow(10, length - i - 1) + 1;
            }
            if (arry[i] == 1){
                sum += n - arry[i] * Math.pow(10, length - i - 1) + 1;
            }
            if (arry[i] == 0){
                sum += 0;
            }
        }

        return (int)sum;

    }
}
