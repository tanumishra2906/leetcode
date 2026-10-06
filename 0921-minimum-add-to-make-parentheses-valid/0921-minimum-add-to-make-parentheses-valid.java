class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int ans = 0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
                if(open>0){ //indicates yes an ( has been found and uske correspondiing ) milte hi sub 1 i.e ( ) +1 -1 got balanced no unmatched
                    open--;   

                }

                else{
                    ans++; /// No '(' available for this ')' i.e open might be 0 or negative which inidcates an closing brac has no opening brac uske pehle
                }
            }
        }

        //now open and ans ka sum will indicated how many bracks needed to make solution valid
        ans=ans+open;
        return ans;   
    }
}


/* Is question mein hum `open` variable se unmatched opening brackets `(` ko track karte hain. Jab `(` mile toh `open++` karte hain, aur jab `)` mile toh agar `open > 0` hai, ek opening bracket ke saath match karke `open--` karte hain. Agar `)` aaye aur `open == 0` ho, iska matlab uske liye koi matching `(` nahi hai, toh ek `(` add karna padega aur `ans++` karenge. String ke end mein agar `open` ki value 0 se greater hai, toh utne unmatched `(` ke liye utne `)` add karne padenge. Isliye final answer `ans + open` hota hai.
 */