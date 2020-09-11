package simple;

public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int result = fib.fib(45);
        System.out.println(result);
    }
    public int fib(int n) {
        //创建数组存储已知数据
        int[] arry = new int[n+1];
        int result = fabo(n,arry);
        return result;
    }
    public int fabo(int n, int[] arry){
        if(arry[n]!=0){
            return arry[n];
        }
        else{
            if(n < 2){
                arry[n] = n;
            }
            else if(n < 45){
                arry[n] = fabo(n-1,arry) + fabo(n-2,arry);
            }
            else{
                arry[n] = (fabo(n-1,arry) + fabo(n-2,arry))%1000000007;
            }
        }
        return arry[n];
    }
}
