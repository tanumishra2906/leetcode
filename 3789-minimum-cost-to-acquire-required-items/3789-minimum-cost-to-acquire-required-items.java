
class Solution{
    public long minimumCost(int cost1,int cost2,int costBoth,int need1,int need2){

        // Dono items alag alag khareedne ki cost Cuz both individually khareedna will cost less
        long ans1=(long)need1*cost1+(long)need2*cost2;

        // Sirf common item khareedne ki cost
        //suppose type 3 (includes both type 1 and 2) ka max lena will cost less than buying indiv at cost 1 and 2.
        long ans2=(long)Math.max(need1,need2)*costBoth;

        // Dono requirements mein common units nikalna
        long common=Math.min(need1,need2);

        // Common items + bachi hui individual items ki cost
        long ans3=(long)common*costBoth+(long)(need1-common)*cost1+(long)(need2-common)*cost2;

        // Sabse minimum cost return karna
        return Math.min(ans1,Math.min(ans2,ans3));

/* Humne 3 different methods se items khareedne ki cost calculate ki:
            ans1 = Sirf individual items khareedne ka cost.
-           ans2 = Sirf Type 3 items khareedne ka cost.
            ans3 = Type 3 + individual items khareedne ka cost.
Ab humein in teeno mein se sabse kam paisa spend karna hai.
Isliye Math.min() use kiya */

    }
}


/* Is question mein humein 5 integers diye gaye hain: `cost1`, `cost2`, `costBoth`, `need1` aur `need2`. Humein Type 1 aur Type 2 items ki required quantity collect karni hai. Type 1 item sirf Type 1 ki requirement complete karta hai, Type 2 item sirf Type 2 ki, jabki Type 3 item dono requirements ko ek saath 1-1 unit increase karta hai. Humein different combinations mein items purchase karke total cost calculate karni hai aur minimum possible cost return karni hai, taaki dono requirements completely satisfy ho jaayein. */
