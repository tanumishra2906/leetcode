import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        for (int l = 0, r = 0; r < n; ++r) {
            sum += arr[r];
            
            while (sum > target) {
                sum -= arr[l++];
            }
            
            if (sum == target) {
                int currLen = r - l + 1;
                
                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[l - 1] + currLen);
                }
                
                best[r] = currLen;
            }
            
            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}