class Solution {
    public String reverseWords(String s) {
        
        // REMOVE EXTRA SPACES
        s = s.trim();
        
        // SPLIT WORDS
        String[] words = s.split("\\s+");
        
        String result = "";
        
        // ADD WORDS IN REVERSE ORDER
        for (int i = words.length - 1; i >= 0; i--) {
            result = result + words[i];
            
            if (i != 0) {
                result = result + " ";
            }
        }
        
        return result;
    }
}