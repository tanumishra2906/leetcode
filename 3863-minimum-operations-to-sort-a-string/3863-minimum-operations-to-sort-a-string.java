
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Check karo string pehle se sorted hai ya nahi
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Length 2 ki unsorted string ko sort nahi kar sakte
        // kyunki poori string ko sort karna allowed nahi hai
        if (n == 2) {
            return -1;
        }

        // String ka sabse chhota aur sabse bada character find karo
        char mn = s.charAt(0);
        char mx = s.charAt(0);

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);

            if (ch < mn) {
                mn = ch;
            }

            if (ch > mx) {
                mx = ch;
            }
        }

        // Agar smallest first par ya largest last par hai,
        // toh ek operation mein string sort ho sakti hai
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }

        // Check karo smallest ya largest character beech mein hai
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }

        // Baaki cases mein 3 operations chahiye
        return 3;
    }
}

/*
Question: String ko minimum operations mein sorted banana hai.
Ek operation mein poori string ko chhodkar koi bhi substring
alphabetical order mein sort kar sakte hain.
Already sorted ho toh 0, impossible ho toh -1 return karo.
*/
