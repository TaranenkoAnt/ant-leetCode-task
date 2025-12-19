package ru.spb.taranenkoant.leetCode;


/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 19.12.2025
 */
public class Task283MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }

}
