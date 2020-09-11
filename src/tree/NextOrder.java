package tree;
import java.util.*;
/**
 * 后续遍历
 */
public class NextOrder {

    public static void main(String[] args) {

    }
    //递归
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> list = new LinkedList<>();
//
//         dfs(root,list);
//
//         return list;
//     }
//     public void dfs(TreeNode root,List<Integer> list){
//         if(root == null){   //为空就直接返回
//             return;
//         }
//         dfs(root.left,list);    //左
//         dfs(root.right,list);   //右
//         list.add(root.val);     //根
//     }

    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new LinkedList<Integer>();
        }

        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        while(root !=  null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                // list.add(root.val);     //根    ===》前序
                root = root.left;           //左
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                // list.add(node.val);     //根    ===》中序

                //右节点为空或者右节点被访问过了
                if(root.right == null ||
                        (list.size() != 0 && list.get(list.size() - 1).equals(root.right.val))){
                    list.add(root.val);
                    root = null;
                }
                else{
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return list;
    }
}
