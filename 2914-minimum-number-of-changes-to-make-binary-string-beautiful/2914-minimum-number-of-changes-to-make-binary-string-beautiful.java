
class Solution {
    public int minChanges(String s) {
        int count = 0;

        // string ko 2-2 characters ke pair mein check karenge
        for (int i = 0; i < s.length(); i += 2) {
            // agar pair ke dono characters different hain
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++; // ek character change karna padega
            }
        }
        return count; // minimum changes
    }
}
