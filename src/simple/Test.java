package simple;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        Test test = new Test();
        int i = test.minArray(new int[]{1, 3, 5});
        System.out.println(i);

    }

    public int minArray(int[] numbers) {
        int result = 0;
        for(int i = 1; i < numbers.length;i++){
            if(numbers[i - 1] > numbers[i]){
                result =  numbers[i];
                break;
            }
            else{
                result =  numbers[0];
            }
        }
        return result;
    }


}
