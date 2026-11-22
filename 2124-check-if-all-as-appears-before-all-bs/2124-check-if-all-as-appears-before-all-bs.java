
class Solution {
    public boolean checkString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            
            // Agar 'b' ke immediately baad 'a' mila
            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
                return false;
            }
        }

        // Agar poori string mein "ba" nahi mila
        return true;
    }
}
