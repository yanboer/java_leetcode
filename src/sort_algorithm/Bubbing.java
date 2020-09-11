package sort_algorithm;


public class Bubbing {
    public static void main(String[] args) {
        int[] listA = new int[]{1, -1, 7, 3, 8, -7, 2, 4, 1};
        Bubbing bubbing = new Bubbing();
        bubbing.bubbing(listA);
        for (int temp : listA) {
            System.out.println(temp);
        }
    }

    public void bubbing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
