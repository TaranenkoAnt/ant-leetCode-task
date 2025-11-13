package ru.spb.taranenkoant.leetCode.medium;


/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 12.11.2025
 */
public class Task238ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] ints = new Task238ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(ints);
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
