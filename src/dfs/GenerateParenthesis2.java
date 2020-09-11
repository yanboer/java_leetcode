package dfs;
import java.util.*;

/**
 *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis2 {
    public static void main(String[] args) {
        GenerateParenthesis2 generateParenthesis2 = new GenerateParenthesis2();
        List<String> list = generateParenthesis2.generateParenthesis(3);
        System.out.println(list);
    }

    String A = "()";

    List<String> list = new LinkedList<>();     //结果

    public List<String> generateParenthesis(int n) {
        int left = 0;   //左括号个数
        int right = 0;  //右括号个数

        dfs(left,right,"",n);

        return list;
    }

    public void dfs(int left,int right,String target,int num){    //num：括号个数
        if(target.length() == num * 2 && left == right){  //符合要求
            list.add(new String(target));
        }
        if(right > left){
            return;
        }
        if(right > num){
            return;
        }
        if(left > num){
            return;
        }

        for(int i = 0;i <= 1;i++){
            String temp = target;
            target += A.substring(i,i + 1); //添加

            if(A.substring(i,i + 1).equals("(")){       //继续遍历
                left++;
                dfs(left,right,target,num);
            }
            if(A.substring(i,i + 1).equals(")")){
                right++;
                dfs(left,right,target,num);
            }

            if(A.substring(i,i + 1).equals("(")){       //回溯
                left--;
            }
            if(A.substring(i,i + 1).equals(")")){
                right--;
            }

            target = temp;      //回溯
        }
    }
}
