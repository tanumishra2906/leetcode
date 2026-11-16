
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            // Har round ke liye nayi string banayenge
            StringBuilder sb = new StringBuilder();
            // k-k digits ke groups banayenge
            for (int i = 0; i < s.length(); i += k) {
                // Har group ka sum initially 0
                int sum = 0;

                // Current group ke digits par loop
                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    // Character ko digit me convert karke add karo
                    sum += s.charAt(j) - '0';
                }
                // Group ka sum nayi string me add karo
                sb.append(sum);
            }
            // Nayi string ko s me store karo
            s = sb.toString();
        }
        // Jab length <= k ho jaye, answer return karo
        return s;
    }
}
