package ru.spb.taranenkoant.leetCode;


import java.util.Locale;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 21.10.2025
 */
public class StringIsPalindrome {

    public static void main(String[] args) {
        isPalindrome("race a car");
    }

    public static boolean isPalindrome(String s) {
        String strNew = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (strNew.isEmpty()) {
            return true;
        }
        char[] chars = strNew.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if(chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static boolean effectiveIsPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // Пропускаем не-буквенно-цифровые символы слева
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            // Пропускаем не-буквенно-цифровые символы справа
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            // Сравниваем символы в нижнем регистре
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
