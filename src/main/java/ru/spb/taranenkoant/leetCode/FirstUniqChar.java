package ru.spb.taranenkoant.leetCode;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 05.11.2025
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            letters[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letters[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
