package list;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
public class HasCycle {
    public static void main(String[] args) {

    }
    //hash表存 ListNode ，如果 key 之前存过了，则表示成环了
    // public boolean hasCycle(ListNode head) {
    //     if(head == null){
    //         return false;
    //     }

    //     boolean flag = false;
    //     Map<ListNode,Integer> map = new HashMap<>();
    //     while(head.next != null && head != null){
    //         if(map.containsKey(head)){  //重复出现了
    //             flag = true;
    //             break;
    //         }
    //         else{
    //            map.put(head,0); //放入 hashmap 中
    //            head = head.next;    //指针后移
    //         }
    //     }

    //     return flag;
    // }

    //使用双指针法  ===》使用两个速度不同的指针，当两个指针相遇到时，则表示成环了
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        boolean flag = false;

        ListNode slow = head;   //指针1
        ListNode fast = head.next;   //指针2(起始位置相差1可以保证更快的相遇)

        //pre1 走一步  pre2 走两步
        /**
         注意这里  =======》
         slow = head.next
         fast = head.next.next

         所以需要 slow.next != null  ====>head.next 有意义
         fast.next != null ====>head.next.next 有意义
         */
        while(slow != null && slow.next != null && fast != null && fast.next != null){
            if(slow.equals(fast)){  //相遇了
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return flag;
    }
}
