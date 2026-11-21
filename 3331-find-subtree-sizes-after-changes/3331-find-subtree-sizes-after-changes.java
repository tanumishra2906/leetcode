
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // Original tree ki adjacency list banao
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // New parent array initially original jaisa hoga
        int[] newParent = parent.clone();

        // Har character ka closest ancestor store hoga
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        // DFS ke liye arrays
        int[] previous = new int[n];
        int[] order = new int[n];

        // Stack se DFS karenge (recursion overflow avoid)
        int[] stack = new int[2 * n];
        int top = 0, idx = 0;

        stack[top++] = 0;

        while (top > 0) {
            int curr = stack[--top];

            if (curr >= 0) {
                // Node mein enter kar rahe hain
                int ch = s.charAt(curr) - 'a';

                // Same character wala ancestor mila?
                if (lastSeen[ch] != -1) {
                    newParent[curr] = lastSeen[ch];
                }

                // Purana ancestor save karo
                previous[curr] = lastSeen[ch];

                // Ab current node closest ancestor banega
                lastSeen[ch] = curr;

                // DFS visiting order save karo
                order[idx++] = curr;

                // Exit ke waqt ancestor restore karna hai
                stack[top++] = ~curr;

                // Original tree ke children visit karo
                for (int child : tree[curr]) {
                    stack[top++] = child;
                }

            } else {
                // Node se bahar aa rahe hain
                int node = ~curr;
                int ch = s.charAt(node) - 'a';

                // Previous ancestor restore karo
                lastSeen[ch] = previous[node];
            }
        }

        // Initially har node ka subtree size 1 hai
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        // Reverse DFS order mein subtree sizes add karo
        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            int p = newParent[node];

            // Child ka size uske new parent mein add karo
            ans[p] += ans[node];
        }

        return ans;
    }
}
