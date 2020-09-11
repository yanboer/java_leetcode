package dp;
import java.util.*;
/**
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 *
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 *
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 *  
 *
 * 示例 2:
 *
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstringInWraproundString {
    public static void main(String[] args) {
        String s = "abcdefghijkabcdefghijklmnabcdefghijklmnopqrstuvwxnopqrstuvwxyzhijklmnrstuvwxklmnopefghijklmnopqrstuvb" +
                "cdefghijklmnopqrsnopqrstuvwdefgijklmghijklbcdefghijklmnopqrstuvwxyghibcdefghijklmqrstuvwxybcdefghijklmno" +
                "pqrstuvopqrstuvnopqrstklmnopqpqrstuvwefghijklmnopqrrsbcdefghijklmnopqrstuvjkdefghijklbabcdefghijklmnopbc" +
                "defghijklmnopqrstuvwxghijklmklmnopqrsbcdefhijklmnonlmnopqrstnopqrabcdefghijklmnopqrstuvwxyznopqrsfghibcd" +
                "efghijklmnoplmnopqrstuvwxypqrstuvpqrstuvwxyqrbcdefghijklmnopqrstuvwefghlmnopqrstuvwefghijklmnopqrsdefghij" +
                "abcdefghijklmnolmnojklmnopqrstklmnopqrstuvlmnopqrsefghijnopqrstuvwxklmnopqrstuvwxyzopqrstuvwijklmnopqrsfg" +
                "hijklmnoghinopqrstuvwjklmnopqrstuvwijklmnopqrstujklmnopqrstuvcdehabcdefghijklmnopuvwxyzjklmnopqrstuvwxyzv" +
                "whijklmnopqrstuvjklmefghijklmnopqrsghijklxyzijklmnoemnopqrstuvvwijklmnopqrstuvwxlmnopqrsjklmnopqrstuvwghi" +
                "jklmnopqrstuvlmnopqrghijklmnopqrstuvwxybcdefghijklmnopqrstuvwxijklmlmnobcdefghijklmnopqrstuvwrstuvjefghij" +
                "klmnopqrstuvwxyzjklmnopqrstuvwxyzijklmnopqrstuvklmnopqrstuvwxcdefghijklmnopqrswxyijklmnofgklmnolmnopqrstu" +
                "vwxyefghijklmnopqrstuvwxybcdefghijklmnopqrsuvwxyklmnopqrstuvwjklopklmnopqrstustuvwxefghijkfghijklmnopqrst" +
                "uvnopqrstustuvwxyzfghijklmnopqrstuvwxmnopqrstuvwuvwghijklmnopqrstuvwxyzjklmnopabcdefghijklmnvwxrstudefghij" +
                "klmnopqrstcdefghijklmnopqcdefghijklmnobcdefghijklmnopqrstjklmnopqrsefghijklmnopqrslmnopqrstuvrstuvablmnopq" +
                "rstuvwxyzghijklmnofghijklmnopqrstughijklmnopqijklmnopqrstucdefghcdefghihijklmnoabcdefghijklmnopqrstuvvwabc" +
                "ddefghijklmnopqrstuvwxyzfghijklmnopqrstabcdefghijklmnopqcdefghijklijklmnopqrstumnopnoghijklmnoprsthijklmno" +
                "pqrstumnopqrsopqrstujklmnopqrstuvwwxopqrstuvwghijklmnopqrstuvwxcdefghijfghijklopqrsdefghijklmnopqrfghijklm" +
                "noijklmnopqrpqrstudefghijkghijklmnopqrstuvwfghijklmnopqrstuvwxyrstucdefghijklmnopqrstuvwlmnopqrstuvwghijkl" +
                "mnopqrstuvwxjklmnopqrstuvwxyijklmnopqrstjklmnoklmnopqrstcdefghijklmnoefghijklmnopqcdefghijklmnopqrmnopqrsp" +
                "mnoefgfghijklmnopqrstuvwxyqrstuvwxyzfghijklmnopdefghxyzopqrstuvdefghijklmnopefghijklmnopqrstuvwxyghijklblm" +
                "noptuabcdefghijklmnopqrstuvwnoefghijklmbcdefghijklmnopqrstuabcdefghijklmnorstuvdefghijklmnopqpqrstdefghijk" +
                "lmnopqrdefghijklmnopqrscdefghijklmnopqfghiklmnefghijklmntuvjklmnopqrstpdefghijklmnopqrsopqqrstuvwxydefgmnop" +
                "qrstuvnopqrstuvabcdefghijklmnijklmnopqrgvwxyabcdefghijklmnrstefghiklmnopqrstuvfghijklmnopqrstuvwxyqrstuvwxe" +
                "fghijklmnopqrstuvwxyfghijklmnopqrstuvwxycdefghijklmnopijklmnopqrstughijijklmnopabcdefghijklmnoplmnopqrstuvw" +
                "ghijklmnopqrsqrstughijklmnabcdefghijklmnopefghijklmnqrstuvwxyzbcdefghijklmnopqrcdefghibcdeabcdefghijklmnopq" +
                "rstucdefghijklmnopqrstuvwxydefghijkdefghijklmnopqrstuvwxyklmdefghefghijklmfghijklmnopqrstdefghijklmnopqabcde" +
                "fghijklmnopqfghijklmnopabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxymnopqrstcdefghijklmnodefghijklbcdefa" +
                "bcdefghijkdefghijklmnocdefghijklmnopqrstuabcdefghijklbcdefghijklcdefghefghiijklmnopqrstuvwxydefghijklmnopqrs" +
                "tuvwxyabcdefghijklmnopklmnopqrbcdefghijklmnopqrstuvwxyzhijklmnopqrstuvwfghijklmnopqrstuvwbcdefghijklmnopqrsb" +
                "cdefghijklmnoopqrstuvwxymnopqrstuvwxyzabcdefghijklmefghijklmnghijklmnoefghijklrstuvwxyzghdefghijklmnopyjkvwa" +
                "bcdefghijklmnopqrstuvcdefghijklmcdefghijklmnbcdefghijklmnopqrsnopqrstuvwlmnoabcdabcdefghijklmnopqrstuvjklmvw" +
                "klmnopqrstuvwxyzdefghijklmnopqrstuvwrstuvwxydefghijklmnopqrstuvwxmnqrstuvijklmnopqrstabcdefghijkefghijklmnop" +
                "qrstuvwklmnopqrstuvwxyzjklmnopqrrstcdefghijklmnoabjklmnopqabcdefghijklmnopqrsijklmnopqrstuvuvwxycdefghijklmf" +
                "ghijklmnopqrstuvtuhijkldefghijklmnopqrstubcdefghijklmnopqrstuvwklmnopqabcdefghijklabcdefghijklmnopqrstuvwxstu" +
                "vwxhopqrstuvwxyzcdefgfghijklmnopqrnabcdefghijklmnopqrstuvwxyzlmnopqrsjklmnopqrstuvjklmnodefmnopqrstuvwxefghi" +
                "jklmnopqrstuvwxmnopqrfghijkcdefghijklmnopqrstuvwxcdefghijklmabklmnopqrstuvwxynopqrshijklmnopqrstuvwxlmnopqrs" +
                "tlmnopqrstuvwtuvnopqdemnocdefghijklmnabcdcdefghijklmghijklmnopqrstuvcdefghijklmnopqrstuvwxghrstuvwxyzlmnopqr" +
                "stuvwxyzmnopqrstuvghinopqrstuvwxbcdefghijklmnopqrsopqrstuvwxypqrstuvwxyznopqrstijklmnoabcdefgfgabcdefghijklm" +
                "klmnopqrstfghijklmnopqfghijabcdefghijklmnonopqrstuvcdefghijklmnopqrstuvwopqrstuvwxmnopqrstuvwxyhijklmnopefgh" +
                "ijklmnopqrstuijklmnopqrstyzbcdefghijkbcdabcdefghijklmnophijklmnopqrstuvwuvfghijklmnopqrstmnghijklmnopqdefghi" +
                "jklmnopqrstuvwqrstuvwxrsthijklmnohijklmklmnopqrstupqrstuopqrstujklmnopqrstklmnopqfghijklmnopqrstumnopghijqrs" +
                "tuvwxabcdefghijklmnopqrsijklmnoprstuvwxabcdefghijklmnopqrstuvijklmnopqrrstuvwxyopqrsijklmnxybcdemnopqrkabcde" +
                "fhijklmnopqrstuvwxqrrstijklmnopqrstcdefghijklmnopqrstuvwxdefghijklmnopqrstunopqrstuvwstuvwxywabcdefghijklmno" +
                "pqrstuvwcdefghidefghijklmnopmnopqrstuvwxdefghijklmnopqrstuvwxyijklmnopqrstuvwxqrstuvwxijklfgbcdefghijklmnopq" +
                "rstuvwxyzfgcstrstijklmnabcdefghijklmnopqrstuvwxyzmnopqrstuvwqrstuvpqrstuvwxypqrstuvwxfghijklmnoabcdefghijklm" +
                "nopfrstuvwlmijklmnopqrstuvhijklmnopqrstujklmnopqrbcdefghijklmnopstrstuvwxyabcdefgpqrstuvwfghwdefghijklmnopef" +
                "ghijklmnopqrabcdefghijklefghijklcdefghijklmnnoghijklmnopcdefghijdefghijklmnopqrsabcdefghijklmndefghijklmnopqr" +
                "stuvwxydefghijklmnopqrstuvwxyzdefghijklmnopqrstuvwxstuuvwhijklmnopqrstfghijklmnopqrstuvwdefghijklmnopqrstefgh" +
                "ijkjklmnopqrstuvjklbcdefghijklmopqrstuvwxyzhijklmnopqrstuvwefghijklmnopqrstuvwxklmnopqabcdefghijklefghijklmno" +
                "pqrstuvwxyzcdefghidefghijklmnopqrstuvwrsteftuvwxyzcdefghhijklmnopqrsijklmnopqrstuvfghijklmnopqrstuvwijklmnopqr" +
                "ijklmnefghidefghijopqrstuvwmnopqrstughijklmnopbcdefghbcdefghdefghijkklmnopqrstuvwxyzbjklmnopqrstuvbcdefghijkl" +
                "mnopqrstuvfghijklmnbcdefijklmnopqrstuvwxymnmnopfghijklmnopqrnopqrstuvwxybcdefghijklmnopqrstucdefghijklmnopqrs" +
                "nopqrstuvuvwxyghiefghijklghijklmnopqrstujklmnhijklmnopqrstuvwxyklghijklmnoopqrsdefghijklmnopqrstuvwbcdefghijk" +
                "lmnopdefghijkgljklmnopqrstuvabcdefghijklmnopqrstuvtuvwxynopqrstuvwxyabcdefghijklmnopqrstuvhijklmnopqrstuvijkl" +
                "mnopqrstuhilmefghijbcdefghijklmnopqrstijjklmnopqrhijklmstuabcdefghijklmnohijklmnopqrstuvwxynopqrjklmocdecdefg" +
                "hijklmnopabcdefghijklmcdefghabcdefghijklmnojklmnopqrstuvwxamnghijklmnodefghijklmnoghijklmnopqrslmnopqrstuvwxy" +
                "fghklmnopqrstuijklmnopqrsklmnopqrqrstuvcdeijklmnopqrsdefghijklefghijklmnopqjklmndefghijklmnopqhijklmnopdefghi" +
                "jklmnopqrstuvwxdefghijklmnopqcefghijklmnopqrlmnopqrstuvwxyzfghijklmnopqrstjklmnpqrstuvwxylmnopqrstlmnopqrsnopq" +
                "rsnojklmnuvwxycdefghijklmnopqrstuvwxefghijklmnopqrstuvwxyzghijklmnopqrstuvvwstuvwxmnopqrstuvwxabcdefgopqrsnopq" +
                "rstuvwxnopqrstuefghijklmnopqrscdefgopqrstijfghijklmnopqrstuvwabcdefghijklmnopqrstuvwxyzdefghivwnopqrstjklmnfgh" +
                "ijklmnoprstuvwxyzlmnopqpqrspqrstuvwxyzklmnopqopqrstuvwxyzabcdefghijklmnopqrstuvcdemnpqmnopqrstuvwxyzstuvwxijkl" +
                "mnopqrstuvweefghijklfghijklmnopqrstuvwxyzjklmnopqrstuvstuefghijklmnopqrstuvabcdefghijklmnopqrstuvwghijklmnopqr" +
                "stughijklmnopqrstrstuvwxyzcdefghijklmnopqrstuvwxopqrstuvwxlmnopqrsmnopqrstuqrstuvwxyzefghicdefghjklmnhijklmnop" +
                "qabcdefghijklmnopqrvwxbcdwxyzklmnopqrstuvefghijklmnopqrsjklmnopqrsopqrstuuvwxyzcdefghijklmnopqrstuvwxyqrstuvde" +
                "fghijklmnopklmnopqbcklmnopqrstuhijklmnopqlmnopqrstuvwxyzfghijklmnopqtuvwcdefghijklmcdefghijklmnopqrstuvwxyzefg" +
                "hijklmnopqrsrstuvwxyghabcdefghijklmnopqrstuvwxyzhijklmefghijklmnopqrstuvwxydefghijklmnopqijklmnopqrspqrstuvwxy" +
                "zfghijklmnopqjklmnopqrstuvwxyuvwxyghijklmnonopqrstghijklmnopqrstuvwijklmnopqrstuvwxbcdefghijklmnopqrstuvwxylmn" +
                "opqrefghijkdefghfghijkjklmndefghijklmnophijklmnopbcdefghijklmnopqrstuvwxymnopqrstuvwxyjklmnopqrstuvefghijklmnop" +
                "qrstabcdefghijklmncderstujklmnopqrsghijklmnopdefghijklmbcdefghijklmnopqrstklmnopqrstuijklmnopqrstuvcdefghijzefg" +
                "hijklmnopqrstuvwxyzuvwxopnopqrstuvwefghijklghijklmnopqjklmnopyzlmnopqrstubcdefghijklijklmnoijklmdefghijklmnopqr" +
                "stuvwxyhijklmnjklmnopqrstuvwxyznopqrstuvwxqrstunopdefgefbcdefghijklmnopqrstuhijklmnopqrstmnojklmnfghdefghijklm" +
                "novwxghijklmnopqqrstuijklmnopqfghijklmnopqrstjabcdefghijabcdefghijklmnopqrstudbcdefghijklmnopqrstuvwxydefghijnopq" +
                "rstabcdefghijklmnopqefnopqefghijklmnopqrstuvlmnopqrstuvwxefghijklmnopqrstcdefghijklmnopqrstuvwxcdhijklmnopqrsqrs" +
                "tuvwxyghifghijghijklmnocdefghijklmnopqrstuvwxabcdefghijklmnoopqrstuvwxyzbcdefgabcdefghijklmnopqrstuvwxyhijklmnop" +
                "qrstbcdefghijklmopqrsefghijklmnopqijklmnopqrstuvqrstuvwqrcdefghijklmnomnopqrstuvwxhijklmnopqstuvwxyzbcfghijkllmn" +
                "opqrhpqrstuvwxybcdefghstxyzbcdefghijklmnonopqrstuvghijklmnopqrstuvwxfghijklmnopqrstbcdefghijklmnopqrmnopqrsabcde" +
                "fghijklmnopqrstuvpqrstuvwxyzhijklmnopqrsttuvwxynopqrsmnopqrcdefghijklmnopqrstdefghijklmstundefghijklmnopqbcdrstu" +
                "vwmnopqrstuvwbcdefghijklmstuvwxyghijklmnopqrstuvwxmnopqrsijklabcdefghijklmnopqrstuvwxfghijklmnopqefghijklmnopqrst" +
                "uvcdefghijklmuvwxmnopuvwklmnopqrsbcdefghijklmnopqrstuvwxyabtuvwxklmnopqrabcdefghijklmnojklmnopqrpqrhiuvwhijklmno" +
                "fbcdefghijklmndefghicdefghirsrsabcdefghijklmnopqrstunopqrefghijklmnopqrstubcdebcdefghijklmnopqrstuopqrstuvwxcdefg" +
                "hijklmnfghijklmnopqrstuvwefghijklmnopqrstuvwxypqrstabcdefghijklbcdlmnopqrstuvwxnopqopqrmnopqrstuvlmnopqrstuvvwxab" +
                "cdefghijklmnopqcdefghijklmnopqrstuabcabcopqhvwjklmefghijklmnoabcdeopdefghijklmnopqrstuvwmnopqrstuvwxyfghijklmnop" +
                "qrstuvwcdefghijklmnokcdefghijklmnopqrstuvwxyqrstuvwefghijkabcdefghijklmnopqrstuvwxystuvlmnopqrsturstfghijklmnopq" +
                "jklmnopqrstuvwxypqrststubklmnopqhijklmnopqrstucdepqrsfghijklmnopqrstuvwxyzcdefghijklmnopqrstuvwxyzijbcdefghijklmn" +
                "opqijklmnpqrstuvefghijghijklmnofghijkghijklmnopjklmnhijklmnbcdefabcdefgzijklmnoabcdefghijklmnopqrabcdefghijklmnop" +
                "qrstuvefghijklmbcdefghijkqrsopqrstuvwxyzfghirstuefghifghijklrstuvwjklmnopqrstyznopqrstuvwxyzfghijklmnopqrstuvwxde" +
                "fghijklmnopqklmnopqrstuvhiijklmnopqrsdefghijklmnopqrstujklmncdefghijklmnopqrstuvwxyzmnopqrstuvwdefghijklmnopghid" +
                "efghijklmnopqbcdefghijklmnopqrstuvwklmnopqrstuabcdefgpjklmnopqrstuvwxyzlmnocdefghijklmnopqrstabcdefghijklefghijk" +
                "lmnopqcdeopqrstrsnopqrstuuvwxyzdepqrhijnopqrsdefghijijklmnopqrstuvmnopqijklmnopqrcdefghijklmnopbcdefghijklmnopqr" +
                "stuvwxymnopqrstuvwxyjklmnopqrstuvwxijklmnopqrstuvwbcdefghijklmnopqlmnopqrstuvwxyabcdefghijkfghijklmncdefghijklmn" +
                "kghijefghijklmnopqrstlmnopqrstuvwxlmnopqqrs";  //正确答案 641
        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        int result = findSubstringInWraproundString.findSubstringInWraproundString(s);
        System.out.println(result);
    }

    //以字符串结尾的子串个数 == 以该字符串结尾的最长子串长度
    //去重  ===》将 p.substring(i,i+1) 作为 key，dp[i + 1]作为 value 存到 map中，然后去重
    public int findSubstringInWraproundString(String p) {
        if(p.length() == 0){
            return 0;
        }

        int[] dp = new int[p.length() + 1]; //dp[i] 表示以 p.substring(i - 1,i)结尾的字符串的子串个数
        dp[1] = 1;


        for(int i = 2;i <= p.length();i++){
            int a = (int)p.charAt(i - 2);    //p 的第 i - 2 个字符(索引为 i - 2)
            int b = (int)p.charAt(i - 1);    //p 的第 i - 1 个字符(索引为 i - 1)

            dp[i] = 1;
            if(b == a + 1 || b == a - 25){
                dp[i] = Math.max(dp[i],dp[i - 1] + 1);
            }
        }

        Map<String,Integer> map = new HashMap<>();

        for(int i = 0;i <= p.length() - 1;i++){
            if(map.containsKey(p.substring(i,i+1))){    //之前存过了
                if(map.get(p.substring(i,i+1)) < dp[i + 1]){    //大于就覆盖掉，小于就不管了
                    map.put(p.substring(i,i+1),dp[i + 1]);
                }
                else{
                    continue;
                }
            }
            map.put(p.substring(i,i+1),dp[i + 1]);  //没存过就存进去
        }

        int sum = 0;        //结果
        for(char i = 'a';i <= 'z';i++){
            if(map.get(String.valueOf(i)) == null){     //没存这个证明 s 里没有
                continue;
            }
            else{
                sum += map.get(String.valueOf(i));
            }
        }

        return sum;
    }
}
