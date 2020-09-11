package dfs;

import com.sun.tools.internal.xjc.model.CEnumConstant;

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

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        System.out.println(list);
    }

    int left = 0;       //记录左括号个数
    int right = 0;      //记录右括号个数


    List<String> list = null;


    String A = "()";
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return new LinkedList<String>();
        }

        list = new LinkedList<>();

        dfs(0,n,"");

        return list;
    }

    public void dfs(int n,int num,String target){     //num代表括号对数
        if(target.length() == num * 2 && left == right){

            list.add(target);
            return;
        }
        else {

            for (int i = 0; i < 2; i++) {
                if (left>=right && left<=num && right<=num) {       //剪枝判断
                    target += A.substring(i, i + 1);
                    if (i == 0) {
                        left++;
                    }
                    if (i == 1) {
                        right++;
                    }

                    dfs(n + 1, num, target);

                    if (i == 0) {
                        left--;
                    }
                    if (i == 1) {
                        right--;
                    }
                    target = target.substring(0, target.length() - 1);       //回溯 ---- 去掉最后一个字符
                }
            }

        }

    }
}
