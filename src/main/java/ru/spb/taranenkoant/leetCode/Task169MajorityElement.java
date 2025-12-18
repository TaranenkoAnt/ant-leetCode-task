package ru.spb.taranenkoant.leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 18.12.2025
 */
public class Task169MajorityElement {

    public int simpleSolution(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                Integer val = map.get(nums[i]);
                val++;
                map.put(nums[i], val);
            } else {
                map.put(nums[i], 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int key = pair.getKey();
            int val = pair.getValue();

            int temp = nums.length/2;
            if (val > temp && val > res) {
                res = key;
            }
        }
        return res;
    }

    public int cleanSolution(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) > n / 2) {
                return num;
            }
        }

        return -1;
    }

    public int BoyerMooreMajorityVoteAlgorithm(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
