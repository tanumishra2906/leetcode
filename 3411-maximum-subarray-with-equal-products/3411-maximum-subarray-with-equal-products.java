class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;
            for(int j = i; j < nums.length; j++) {
                // Product update
                prod = prod * nums[j];
                // GCD update
                g = gcd(g, nums[j]);
                // LCM update
                l = (l *nums[j]) / gcd(l, nums[j]);
                // Condition check
                if(prod == g*l) {
                    max = Math.max(max, j - i + 1);
                }
                // Invalid subarray ko extend karna useless hai
                if(prod> g*l) {
                    break;
                }
            }
        }
        return max;
    }
    // GCD using Euclidean Algorithm
    public long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}