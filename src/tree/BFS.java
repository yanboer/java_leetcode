package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先
 */
public class BFS {
    public static void main(String[] args) {

    }

    //BFS
    //相同的树的广度优先搜索结果相同
    public void bfs(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();  //queue 队列实现广度优先搜索
        queue.offer(node);      //添加元素

        while(!queue.isEmpty()){        //队列不为空
            node = queue.poll();
            if(node.left != null){      //左节点不为空
                queue.offer(node.left);
            }
            if(node.right != null){     //右节点不为空
                queue.offer(node.right);
            }
            list.add(node.val);     //添加到 list
        }
    }
}
