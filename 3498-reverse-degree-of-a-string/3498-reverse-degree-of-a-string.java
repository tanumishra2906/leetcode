class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a' + 1;
            int reverseValue = 26 - (value - 1);

            sum += reverseValue * (i + 1);
        }

        return sum;
    }
}