package ru.spb.taranenkoant.leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 10.11.2025
 */
public class Task1TwoSum {

    public static void main(String[] args) {
        new Task1TwoSum().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(1);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];

            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
/**
 * Map<Integer, Integer> numToIndex = new HashMap<>();
 *
 *         // [2, 7, 11, 15]
 *         for (int i = 0; i < nums.length; i++) {
 *             // получаем разницу от target, что нужно прибавить к nums[i], чтобы получить target
 *             //  9 - 2 = 7
 *             int complement = target - nums[i];
 *             //если в мапе уже есть это число, то возвращаем текущее значение и разницу
 *             // при nums[i] == 2 (7) 2 уже есть в мапе в качестве значения
 *             if (numToIndex.containsKey(complement)) {
 *                 return new int[]{numToIndex.get(complement), i};
 *             }
 *             //при первом проходе 7 попадает в мапу
 *             numToIndex.put(nums[i], i);
 *         }
 *         return new int[0];
 * */