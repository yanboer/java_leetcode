package test;
import org.junit.Test;

import java.util.*;

public class Le {
    @Test
    public void test(){
        int[] a = {2,4,3,1,5};

        int[] te = {1,2,3,4,5};
//        int[] res = cal(2,te);
        boolean res = isMagic(a);
//        System.out.println(Arrays.toString(res));
        System.out.println(res);
    }
    public boolean isMagic(int[] target) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        int n = target.length;  //长度
        int[] a = new int[n];
        int[] b = new int[n];
        boolean flag = false;
        for(int i = 0;i < n;i++){
            a[i] = i + 1;
            b[i] = i + 1;
            list1.add(target[i]);
        }

        for(int i = 0;i < n;i++){   //k --> k + 1
            a = cal(i + 1,a);
            for(int j = 0;j < a.length;j++){
                list2.add(a[j]);
            }
            if(list1.equals(list2)){
                flag = true;
                return true;
            }
            a = b;
            list2.clear();
        }
        return flag;
    }

    public int[] cal(int k,int[] a){
        int n = a.length;
        int[] tar = new int[n];
        int[] b = revnum(a);
        boolean flag = true;
        int index = 0;

        while(flag) {
            for (int i = 0; i < k; i++) {
                tar[i + index * k] = b[i];
                if(tar[n - 1] != 0){
                    flag = false;
                    return tar;
                }
            }
            b = del(b,k);   //删除
            b = revnum(b);  //再反转
            index++;
        }

        return tar;
    }

    public int[] del(int[] a,int k){    //删除前k个数
        int n = a.length;
        int[] tar = new int[n - k];
        for(int i = k;i < n;i++){
            tar[i - k] = a[i];
        }
        return tar;
    }

    //偶数放在奇数前面
    public int[] revnum(int[] arry){
        int n = arry.length;
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i < n;i++){       //偶数
            if((i + 1)%2 == 0){
                list.add(arry[i]);
            }
        }
        for(int i = 0;i < n;i++){       //奇数
            if((i + 1)%2 != 0){
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
