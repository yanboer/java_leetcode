package tree;
import java.util.*;
/**
 * 前续遍历
 */

//节点
class TreeNode{
    int val;    //节点值
    TreeNode left;  //左节点
    TreeNode right; //右节点
    public void TreeNode(int val){
        this.val = val;
    }

}
public class Preorder {
    public static void main(String[] args) {

    }
    //递归
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new LinkedList<>();
//
//         dfs(root,list);
//
//         return list;
//     }
//
//     public void dfs(TreeNode node,List<Integer> list){
//         if(node == null){
//             return;
//         }
//         list.add(node.val);
//         dfs(node.left,list);
//         dfs(node.right,list);
//     }

    //迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();    //结果
        Stack<TreeNode> stack = new Stack<>();  //栈保存信息

        while(!stack.isEmpty() || root != null){
            while(root != null){
                list.add(root.val);     //加入list
                stack.push(root);
                root = root.left;       //左边
            }
            if(!stack.isEmpty()) {
                TreeNode node = stack.pop();       //弹出
                root = node.right;      //右边
            }
        }

        return list;
    }
}
