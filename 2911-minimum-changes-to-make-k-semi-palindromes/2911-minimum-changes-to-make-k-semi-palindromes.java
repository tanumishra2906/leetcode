import java.util.*;

class Solution {
    public int minimumChanges(String s,int k){
        int n=s.length();
        char[] a=s.toCharArray();
        int[][] cost=new int[n][n];

        // Har substring ko semi-palindrome banane ka min cost
        for(int len=2;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int best=len;

                // Har possible divisor check karo
                for(int d=1;d<len;d++){
                    if(len%d!=0)continue;
                    int changes=0;

                    // d ke according groups banao
                    for(int r=0;r<d;r++){
                        int l=i+r;
                        int h=i+r+(len/d-1)*d;

                        // Group ko palindrome banane ke changes
                        while(l<h){
                            if(a[l]!=a[h])changes++;
                            l+=d;
                            h-=d;
                        }
                    }
                    best=Math.min(best,changes);
                }
                cost[i][i+len-1]=best;
            }
        }

        // dp[p][i] = first i characters ko p parts me divide karne ka min cost
        int[][] dp=new int[k+1][n+1];
        for(int[] row:dp)Arrays.fill(row,1000000);
        dp[0][0]=0;

        for(int p=1;p<=k;p++){
            for(int i=2*p;i<=n;i++){
                // Har part ki minimum length 2 hogi
                for(int j=2*(p-1);j<=i-2;j++){
                    dp[p][i]=Math.min(dp[p][i],
                    dp[p-1][j]+cost[j][i-1]);
                }
            }
        }
        return dp[k][n];
    }
}