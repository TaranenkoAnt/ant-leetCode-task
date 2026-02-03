package ru.spb.taranenkoant;


/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 03.02.2026
 */
public class Task344ReverseString {

    public static void main(String[] args) {
        char[] test = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int iterations = 1000000;

        // Тест 1: Ваш исходный подход
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            reverseString(test.clone());
        }
        System.out.println("Original: " + (System.nanoTime() - start) / 1e6 + " ms");

        // Тест 2: Без условия
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            reverseStringNoCheck(test.clone());
        }
        System.out.println("No check: " + (System.nanoTime() - start) / 1e6 + " ms");

        // Тест 3: XOR swap
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            reverseStringXOR(test.clone());
        }
        System.out.println("XOR: " + (System.nanoTime() - start) / 1e6 + " ms");
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
            }
        }
    }

    public static void reverseStringNoCheck(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    public static void reverseStringXOR(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}
