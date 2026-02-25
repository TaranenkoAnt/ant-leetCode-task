package ru.spb.taranenkoant;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 25.02.2026
 */
public class Task448FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbersNotEffective(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i < nums.length + 1; i++) {
            if (set.contains(i)) {
                continue;
            }
            list2.add(i);
        }
        return list2;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Первый проход: пометка присутствующих чисел
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // число может стать отрицательным, берём модуль
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Второй проход: поиск непомеченных
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
