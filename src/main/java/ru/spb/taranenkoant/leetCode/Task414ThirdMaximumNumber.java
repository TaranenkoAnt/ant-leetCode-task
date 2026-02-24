package ru.spb.taranenkoant.leetCode;


import java.util.*;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 24.02.2026
 */
public class Task414ThirdMaximumNumber {

    public static void main(String[] args) {
        System.out.println(new Task414ThirdMaximumNumber().thirdMax(new int[]{2, 2, 3, 1}));
    }

    public int thirdMaxNotEffective(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        List<Integer> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        if (list.size() >= 3) return list.get(2);
        else return list.get(0);
    }

    public int thirdMax(int[] nums) {
        // Используем Long, чтобы корректно обрабатывать Integer.MIN_VALUE
        long first = Long.MIN_VALUE;  // наибольшее
        long second = Long.MIN_VALUE; // второе
        long third = Long.MIN_VALUE;  // третье

        for (int num : nums) {
            // Пропускаем дубликаты (уже учтённые значения)
            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        // Если третье значение было обновлено (т.е. есть минимум три уникальных числа)
        if (third != Long.MIN_VALUE) {
            return (int) third;
        } else {
            return (int) first;
        }
    }
}
