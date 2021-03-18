package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 1、dfs 遍历记录每个节点的父节点
 * 2、对 p q 分别进行父节点遍历，第一个重复的就是最近公共祖先
 */
public class LowestCommonAncestor {
    //存储父节点
    Map<Integer,TreeNode> map = new HashMap<>();

    //存储路径
    Set<TreeNode> set = new HashSet<>();


    //1、dfs 遍历记录每个节点的父节点
    //2、对 p q 分别进行父节点遍历，第一个重复的就是最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        // Set<Integer> keySet = map.keySet();
        // for(Integer temp : keySet){
        //     System.out.println(map.get(temp).val);
        // }

        //当前节点入路径
        set.add(p);

        while(p != null){
            set.add(map.get(p.val));
            p = map.get(p.val);
        }
        while(q != null){
            if(set.contains(q)){
                return q;
            }
            q = map.get(q.val);
        }

        return null;
    }

    public void dfs(TreeNode root){
        if(root.left != null){
            map.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
