package dfs;
import java.util.*;
/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

public class PathSum {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new LinkedList<>();   //结果

    //dfs
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new LinkedList<>();
        dfs(root,list,sum);

        return res;
    }

    public void dfs(TreeNode node,List<Integer> list,int sum){
        if(node == null){
            return;
        }
        list.add(node.val); //添加该节点到 list     ===> 这一步一定要放到求和之前
        // System.out.println(list);

        int listSum = 0;    //集合之和
        for(int i = 0;i <= list.size() - 1;i++){    //求和
            listSum += list.get(i);
        }
        if(listSum == sum && node.left == null && node.right == null){    //是叶子节点且满足要求
            res.add(new LinkedList<Integer>(list));     //添加到 res
            return;
        }
        if(node.left != null){
            dfs(node.left,list,sum);        //左递归
            list.remove(list.size() - 1);     //回溯
        }
        if(node.right != null){
            dfs(node.right,list,sum);        //右递归
            list.remove(list.size() - 1);     //回溯
        }
    }
}
