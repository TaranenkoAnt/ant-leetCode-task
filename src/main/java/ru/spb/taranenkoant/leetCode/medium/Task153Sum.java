package ru.spb.taranenkoant.leetCode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 12.11.2025
 */
public class Task153Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Сортируем массив - ключевой шаг!

        for (int i = 0; i < nums.length - 2; i++) {
            // Пропускаем дубликаты для первого элемента
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Нашли валидную тройку
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Пропускаем дубликаты для left и right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Нужна большая сумма
                } else {
                    right--; // Нужна меньшая сумма
                }
            }
        }

        return result;
    }
}
