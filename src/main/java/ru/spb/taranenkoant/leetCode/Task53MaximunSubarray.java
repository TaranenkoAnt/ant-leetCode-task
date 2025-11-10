package ru.spb.taranenkoant.leetCode;


import java.util.Arrays;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 10.11.2025
 */
public class Task53MaximunSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int current = 0;
        for (int num : nums) {
            current = Math.max(num, current + num);
            maxSum = Math.max(maxSum, current);
        }

        return maxSum;
    }

    public int maxSubArrayWithIndices(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Переменные для отслеживания индексов
        int start = 0, end = 0;
        int tempStart = 0; // Временное начало текущего подмассива

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                // Начинаем новый подмассив с i
                currentSum = nums[i];
                tempStart = i; // Новое начало
            } else {
                // Продолжаем текущий подмассив
                currentSum = currentSum + nums[i];
            }

            // Обновляем максимальную сумму и индексы
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Подмассив: от " + start + " до " + end);
        System.out.println("Элементы: " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));

        return maxSum;
    }
}
