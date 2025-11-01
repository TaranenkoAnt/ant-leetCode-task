package ru.spb.taranenkoant.leetCode;


import java.util.Stack;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 31.10.2025
 */
public class ValidVarentheses {

    public static void main(String[] args) {
        System.out.println(new ValidVarentheses().isValid("([{}][{}])"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                // Проверяем, что скобки ПАРНЫЕ
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
