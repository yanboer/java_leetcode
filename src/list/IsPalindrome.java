package list;
import java.util.*;
/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }
    List<Integer> list1 = new LinkedList<>();  //slow

    List<Integer> list2 = new LinkedList<>();  //fast

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        if(head.next.next == null){
            if(head.val == head.next.val){
                return true;
            }
            else{
                return false;
            }
        }
        int sum = 0;    //链表元素个数
        ListNode pre = head;
        while(pre != null){
            sum++;
            pre = pre.next;
        }

        ListNode slow = head;   //慢指针
        ListNode fast = head;   //快指针

        for(int i = 1;i <= sum/2;i++){
            fast = fast.next;
        }
        while(fast != null){
            list1.add(slow.val);
            slow = slow.next;

            list2.add(fast.val);
            fast = fast.next;
        }

        for(int i = 0;i <= list1.size() - 1;i++){
            if(list1.get(i) != list2.get(list2.size() - 1 - i)){
                return false;
            }
        }

        return true;
    }
}
