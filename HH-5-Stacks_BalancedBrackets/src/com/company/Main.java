package com.company;

import java.util.*;

public class Main {
    public static char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static boolean isOpenTerm(char c) {
        for (char[] array : TOKENS) {
            if (array[0] == c)
                return true;
        }
        return false;
    }

    public static boolean matches(char openTerm, char closeTerm) {
        for (char[] array : TOKENS) {
            if (array[0] == openTerm) {
                return array[1] == closeTerm; //true or false
            }
        }
        return false;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !matches(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // write your code here
        String exp = "{{}";
        System.out.println(isBalanced(exp));
    }
}
