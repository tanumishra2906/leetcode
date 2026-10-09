
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If we have an odd number of ')'
                // requirements, insert one ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (open > 0) {
                        open--;
                    } else {
                        ans++;
                    }
                    i++; // Consume the second ')'
                } else {
                    // Only one ')' available, so insert another ')'
                    ans++;

                    if (open > 0) {
                        open--;
                    } else {
                        ans++; // Insert a matching '('
                    }
                }
            }
        }

        return ans + 2 * open;
    }
}