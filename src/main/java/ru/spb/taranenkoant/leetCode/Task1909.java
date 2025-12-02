package ru.spb.taranenkoant.leetCode;


/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 01.12.2025
 */
public class Task1909 {

    public static void main(String[] args) {
        boolean answer = canBeIncreasing(new int[]{541,783,433,744});
        System.out.println(answer);
    }

    public static boolean canBeIncreasing(int[] nums) {
        boolean isGood = true;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                if (!isGood) {
                    return false;
                }
                isGood = false;
                if (i == 1 || nums[i] > nums[i-2]) {
                    prev = nums[i];
                }
                continue;
            }
            prev = nums[i];

        }
        return true;
    }
}
