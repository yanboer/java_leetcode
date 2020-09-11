package dp;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 *          //dp[i] 表示 i 长度的字符串能否被识别
 *         //dp[i] = dp[j] && checkWord(s.substring(j,i),wordDict);
 *         //例如： dp["leetcode"] = dp["leet"] + checkWord("code");
 *         //例如： dp["leet"] = dp[""] + checkWord("leet");
 */
public class WordBreak {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");



        WordBreak wordBreak = new WordBreak();
//        boolean test = wordBreak.checkWord("code", list);
//        System.out.println(test);

        boolean result = wordBreak.wordBreak("leetcode", list);
        System.out.println(result);

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();        //待识别字符串长度
        boolean[] dp = new boolean[length+1];     //dp[i] 表示 i 长度的字符串能否被识别


        dp[0] = true;   // 初始化

        for(int i = 1;i<=length;i++){
            for(int j = 0;j<i;j++){
                //dp[i] = dp[j] && checkWord(s.substring(j,i),wordDict);
                //例如： dp["leetcode"] = dp["leet"] + checkWord("code");
                //例如： dp["leet"] = dp[""] + checkWord("leet");
                dp[i] = dp[j] && checkWord(s.substring(j,i),wordDict);
                if (dp[i]){     //有一种情况可以推出，则为真，退出本层循环
                    break;
                }
            }
        }

        return dp[length];
    }

    //识别单词
    public boolean checkWord(String s, List<String> wordDict){
        for(String temp:wordDict){
            if(temp.equals(s)){
                return true;
            }
        }
        return false;
    }
}
