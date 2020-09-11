package tree;
import java.util.*;
/**
 * 深度优先
 */
public class DFS {
    public static void main(String[] args) {

    }
    //相同的树的深度优先搜索结果相同

    //递归
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//
//         List<Integer> list1 = new LinkedList<>();
//         List<Integer> list2 = new LinkedList<>();
//
//         dfs(p,list1);
//         // System.out.println();
//         dfs(q,list2);
//
//
//         if(list1.equals(list2)){
//             return true;
//         }
//
//         return false;
//     }
//
//     public void dfs(TreeNode node,List<Integer> list){
//         if(node == null){
//             list.add(0);        //空节点添加 0 表示该位置为空
//             // System.out.print(0 + "->");
//             return;
//         }
//         list.add(node.val);     //添加值
//         // System.out.print(node.val + "->");
//         dfs(node.left,list);    //左递归
//         dfs(node.right,list);   //右递归
//     }

    //非递归
    public boolean isSameTree(TreeNode p, TreeNode q) {

        List<Integer> list1 = new LinkedList<>();   //存储 p 的遍历结果
        List<Integer> list2 = new LinkedList<>();   //存储 q 的遍历结果

        dfs(p,list1);
        dfs(q,list2);

        if(list1.equals(list2)){
            return true;
        }

        return false;
    }

    //相同的树的深度优先搜索结果相同
    public void dfs(TreeNode node,List<Integer> list){
        if(node == null){       //根节点为空就添加0 返回
            list.add(0);
            return;
        }
        Stack<TreeNode> stack = new Stack<>();  //栈

        stack.push(node);       //添加当前节点到栈

        while(!stack.isEmpty()){    //栈不为空
            node = stack.pop();   //弹出当前节点
            list.add(node.val);            //添加到 list

            //先右后左，出栈时就会先左后右
            if(node.right != null){    //右节点不为空
                stack.push(node.right);
            }
            if(node.left != null){    //左节点不为空
                stack.push(node.left);
            }
        }
    }
}
