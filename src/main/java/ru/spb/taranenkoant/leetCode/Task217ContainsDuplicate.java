package ru.spb.taranenkoant.leetCode;


import java.util.HashSet;
import java.util.Set;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 10.11.2025
 */
public class Task217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for (int i : nums) {
            if (duplicate.contains(i)) {
                return true;
            }
            duplicate.add(i);
        }
        return false;
    }

    public boolean effectiveContainsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean effectiveContainsDuplicate2(int[] nums) {
        if (nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
