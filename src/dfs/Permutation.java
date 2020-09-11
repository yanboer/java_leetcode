package dfs;
import java.util.*;
/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] result = permutation.permutation("abc");
    }

    List<String> list = new LinkedList<>();
    boolean[] color = null;

    public String[] permutation(String s) {
        int n = s.length();
        color = new boolean[n];
        if(n == 1){
            String[] temp = new String[0];
            return temp;
        }
        dfs(s,"");
        System.out.println(list);
        String[] res = new String[list.size()];
        Object[] obj = list.toArray();
        for(int i = 0;i <= obj.length - 1;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void dfs(String s,String a){
        if(a.length() == s.length()){    //满足条件
            String temp2 = a;
            list.add(temp2);
        }
        for(int i = 0;i <= s.length() - 1;i++){
            if(color[i] == true){
                continue;
            }
            color[i] = true;    //标记
            String temp = a;
            a += s.substring(i,i+1);    //加入字符集
            dfs(s,a);                   //遍历
            a = temp;                   //回溯
            color[i] = false;
        }
    }
}
