import java.util.*;

class Solution {
    int idx = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    Set<String> parse(String s) {
        Set<String> res = new HashSet<>();
        res.add("");

        while (idx < s.length() && s.charAt(idx) != '}') {
            char ch = s.charAt(idx);

            if (ch == ',') {
                idx++;
                res.addAll(parse(s));
            } else {
                Set<String> next;
                if (ch == '{') {
                    idx++;
                    next = parse(s);
                    idx++;
                } else {
                    next = new HashSet<>();
                    next.add(String.valueOf(ch));
                    idx++;
                }

                res = multiply(res, next);
            }
        }

        return res;
    }

    Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> res = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                res.add(x + y);
            }
        }
        return res;
    }
}