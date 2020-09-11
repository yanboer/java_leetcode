package dfs;

import java.util.*;
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("23");
//        List<String> list = letterCombinations.letterCombinations("");
//        List<String> list = letterCombinations.letterCombinations("22");
        System.out.println(list);



    }

    String[][] num = new String[][]{
            {"","",""," "},{"","",""," "},{"a","b","c"," "},{"d","e","f"," "},{"g","h","i"," "},{"j","k","l"," "},{"m","n","o"," "},{"p","q","r","s"},{"t","u","v"," "},{"w","x","y","z"}
};      //使 "abc" 对应 数字2

    boolean[][] color = null;       //标记
    int[] n_num = null;           //挑选的 n 数组，用来标记两个数相等的情况
    public List<String> letterCombinations(String digits) {
        List<String> list_temp = new LinkedList<String>();
        if ((digits.length() == 0)){
            return list_temp;
        }

        List<String> list = new LinkedList<>();


        color = new boolean[10][4];     //使 2 对应 {"a","b",c"}
        n_num = new int[8];

        dfs(0,list,digits,"");
        return list;

    }
    public void dfs(int n,List<String> list,String digits,String target){
        if(n == digits.length()){
            target.replace(" ","");
            if (target.contains(" ")){      //有空字符
                return;
            }
            list.add(target);       //复制后添加进 list

            return;
        }
        else{
            for(int i = 0;i < 4;i++){
                int a = Integer.valueOf(digits.substring(n,n+1));
                if(!color[a][i]||n_num[n] != 1){        //重复了
                    color[a][i] = true;   //标记
                    n_num[n] = 1;

                    target = target + num[a][i];
                    dfs(n+1,list,digits,target);

//                    String target1 = target.substring(0, n);           //回溯
//                    String target2 = target.substring(n + 1, target.length());
//                    target = target1 + target2;
                    target = target.substring(0,target.length()-1);
//                    target = target.replace(num[a][i],"");           //回溯
                    n_num[n] = 0;
                    color[a][i] = false;
                }
            }
        }
    }



}
