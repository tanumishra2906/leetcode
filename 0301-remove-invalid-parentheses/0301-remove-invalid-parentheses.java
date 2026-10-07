import java.util.*;

class Solution {

    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int removeLeft = 0;
        int removeRight = 0;

        // Find minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                removeLeft++;
            }

            else if (ch == ')') {

                if (removeLeft > 0) {
                    removeLeft--;
                }
                else {
                    removeRight++;
                }
            }
        }

        backtrack(s, 0, 0, removeLeft, removeRight, "");

        return new ArrayList<>(ans);
    }

    private void backtrack(String s, int index, int balance,
                            int removeLeft, int removeRight,
                            String current) {

        // End of string
        if (index == s.length()) {

            if (balance == 0 &&
                removeLeft == 0 &&
                removeRight == 0) {

                ans.add(current);
            }

            return;
        }

        char ch = s.charAt(index);

        // Case 1: '('
        if (ch == '(') {

            // Remove '('
            if (removeLeft > 0) {
                backtrack(
                    s,
                    index + 1,
                    balance,
                    removeLeft - 1,
                    removeRight,
                    current
                );
            }

            // Keep '('
            backtrack(
                s,
                index + 1,
                balance + 1,
                removeLeft,
                removeRight,
                current + ch
            );
        }

        // Case 2: ')'
        else if (ch == ')') {

            // Remove ')'
            if (removeRight > 0) {
                backtrack(
                    s,
                    index + 1,
                    balance,
                    removeLeft,
                    removeRight - 1,
                    current
                );
            }

            // Keep ')' only if it doesn't make balance negative
            if (balance > 0) {
                backtrack(
                    s,
                    index + 1,
                    balance - 1,
                    removeLeft,
                    removeRight,
                    current + ch
                );
            }
        }

        // Case 3: normal character
        else {

            backtrack(
                s,
                index + 1,
                balance,
                removeLeft,
                removeRight,
                current + ch
            );
        }
    }
}