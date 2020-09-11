package tree;
import java.util.*;
/**
 * 中序遍历
 */


public class Inorder {
    public static void main(String[] args) {

    }

    //递归
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new LinkedList<>();
//         dfs(root,list);
//
//         return list;
//     }
//
//     public void dfs(TreeNode node,List<Integer> list){
//         if(node == null){
//             return;
//         }
//         dfs(node.left,list);    //向左遍历
//         list.add(node.val);     //根节点值
//         dfs(node.right,list);   //向右遍历
//     }


    //迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;       //左
            }
            if(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);         //根
                root = node.right;          //右
            }
        }

        return list;
    }
}
