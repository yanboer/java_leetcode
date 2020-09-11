package dfs;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    public static void main(String[] args) {
        char[][] maze = {
                {'A','B','C','E'},
                {'S','F','C','F'},
                {'A','D','E','E'},
        };

        String string1 = "ABCCED";

        Exist exist = new Exist();
        boolean result = exist.exist(maze, string1);
        System.out.println(result);
    }

    boolean[][] color = null;       //标记迷宫的哪些位置走个

    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || word.length() == 0){
            return false;
        }
        color = new boolean[board.length][board[0].length];

        String start_string = word.substring(0,1);      //第一个字符

        for(int i = 0;i <= board.length - 1;i++){
            for(int j = 0;j <= board[i].length - 1;j++){
                if(start_string.equals(String.valueOf(board[i][j]))){
                    dfs(j,i,board,word,"");    //j 是 x 坐标，i 是 y 坐标
                }
                if(flag == true){   //找到直接返回
                    return true;
                }
            }
        }

        return flag;
    }
    /**
     int x:当前位置的 x 坐标
     int y:当前位置的 y 坐标
     char[][] board:迷宫本身
     String target:目标字符串
     String now_string:当前已完成字符串
     boolean flag:能否凑出
     */
    public void dfs(int x,int y,char[][] board,String target,String now_string){
        if(now_string.equals(target)){  //可以拼出来
            flag = true;
//            System.out.println(flag);
//            System.exit(0); //执行完一次输出就退出程序
            return;
        }
        else{
            if(x < 0 || y < 0){        //越界
                return;
            }
            if(x >= board[0].length ||y >= board.length){     //越界
                return;
            }

            if(color[y][x] == true){    //走过了
                return;
            }
            if(!now_string.equals(target.substring(0,now_string.length()))){    //不满足条件就直接退出
                return;
            }
            if(flag == true){       //找到就直接退出
                return;
            }

            String temp = now_string;

            color[y][x] = true;     //标记
            now_string += String.valueOf(board[y][x]);

            dfs(x,y + 1,board,target,now_string);        //继续遍历
            dfs(x,y - 1,board,target,now_string);
            dfs(x + 1,y,board,target,now_string);
            dfs(x - 1,y,board,target,now_string);

            now_string = temp;      //回溯
            color[y][x] = false;
        }
    }
}
