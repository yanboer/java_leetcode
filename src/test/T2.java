package test;
import org.junit.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class T2 {
    public static void main(String[] args) {
        Integer a = -128;
        Integer b = -128;

        Integer c = -129;
        Integer d = -129;

        Integer e = 127;
        Integer f = 127;

        Integer g = 128;
        Integer h = 128;

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(g == h);

    }

    @Test
    public void test(){
        int a = Integer.parseInt("1");          //返回基本类型
        Integer integer = Integer.valueOf("12");        //返回包装类型
    }

    @Test
    public void test1(){
        StringBuffer s = new StringBuffer();
        s.append("a");
        s.append("b");
        s.append("c");
        s.setCharAt(2,'g');

        System.out.println(s);
    }

    @Test
    public void test2(){
        List list = new CopyOnWriteArrayList();     //线程安全
    }

    @Test
    public void test3(){
        int[] a = {1,2,3,4,5};
        int[] ints = revnum(a);
        System.out.println(Arrays.toString(ints));
    }
    //偶数放在奇数前面
    public int[] revnum(int[] arry){
        int n = arry.length;
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i < n;i++){       //偶数
            if(arry[i]%2 == 0){
                list.add(arry[i]);
            }
        }
        for(int i = 0;i < n;i++){       //奇数
            if(arry[i]%2 != 0){
                list.add(arry[i]);
            }
        }
        int[] target = new int[n];
        for(int i = 0;i < n;i++){
            target[i] = list.get(i);
        }
        return target;
    }
}
