package list;

/**
 *  leetcode:203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        //头结点单独处理
        while(head.val == val && head.next != null){
            head = head.next;       //下个节点值给当前节点
        }

        if(head.val == val && head.next == null){
            return head.next;
        }

        ListNode pre = head;

        while(pre.next != null && pre != null){   //下一个节点不为空且当前节点不为空
            if(pre.next.val == val){ //下一个节点值等于给定值(要删除的节点))
                pre.next = pre.next.next;               //当前节点指向下一个节点
            }
            else{
                pre = pre.next;   //指针后移
            }
        }
        return head;
    }
}
