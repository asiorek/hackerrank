package com.roczniak.hackerrank;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        boolean isBalanced = false;
        Stack<Character> brackets = new Stack<>();

        for (Character letter : s.toCharArray()) {
            switch (letter) {
                case '{':
                case '(':
                case '[':
                    brackets.push(letter);
                    break;
                case '}':
                    try {
                        if (brackets.peek() != null && brackets.peek().equals('{')) {
                            brackets.pop();
                            isBalanced = true;
                            break;
                        } else {
                            isBalanced = false;
                            return "NO";
                        }
                    } catch (EmptyStackException exception) {
                        isBalanced = false;
                        return "NO";
                    }
                case ')':
                    try {
                        if (brackets.peek() != null && brackets.peek().equals('(')) {
                            brackets.pop();
                            isBalanced = true;
                            break;
                        } else {
                            isBalanced = false;
                            return "NO";
                        }
                    } catch (EmptyStackException exception) {
                        isBalanced = false;
                        return "NO";
                    }
                case ']':
                    try {
                        if (brackets.peek() != null && brackets.peek().equals('[')) {
                            brackets.pop();
                            isBalanced = true;
                            break;
                        } else {
                            isBalanced = false;
                            return "NO";
                        }
                    } catch (EmptyStackException exception) {
                        isBalanced = false;
                        return "NO";
                    }

            }
        }
        return brackets.empty() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
