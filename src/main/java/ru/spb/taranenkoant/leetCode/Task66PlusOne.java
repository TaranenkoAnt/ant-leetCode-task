package ru.spb.taranenkoant.leetCode;


/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 02.12.2025
 */
public class Task66PlusOne {
    public static void main(String[] args) {
        int[] ints = effectivePlusOne(new int[]{8, 9, 9, 9});
        System.out.println(ints.length);
    }

    public static int[] effectivePlusOne(int[] digits) {
        int length = digits.length;

        for (int i = length - 1;i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        for (int i = 0; i < length; i++) {
            result[i + 1] = 0;
        }
        return result;
    }

    public static int[] myPlusOne(int[] digits) {
        int length = digits.length;
        int start = digits[0];
        int end = digits[length - 1];
        if (end < 9) {
            digits[length - 1] = end + 1;
            return digits;
        }

        if (length == 1 && start == 9) {
            return new int[] {1, 0};
        }

        boolean needIncrement = false;
        for (int i = length - 1; i >= 0; i--) {
            int val = digits[i];
            if (i == length - 1) {
                val = val + 1;
                if (val > 9) {
                    val = 0;
                    digits[i] = val;
                    needIncrement = true;
                    continue;
                }
                digits[i] = val;
            }

            if (needIncrement) {
                val = val + 1;
                if (val > 9) {
                    val = 0;
                    digits[i] = val;
                    continue;
                }
                digits[i] = val;
                needIncrement = false;
            }
        }

        if (needIncrement) {
            int[] result = new int[length + 1];
            result[0] = 1;

            for (int i = 0; i < length; i++) {
                int val = digits[i];
                if (val > 9) {
                    result[i + 1] = 0;
                    continue;
                }
                result[i + 1] = digits[i];
            }
            return result;
        }

        return digits;
    }
}
