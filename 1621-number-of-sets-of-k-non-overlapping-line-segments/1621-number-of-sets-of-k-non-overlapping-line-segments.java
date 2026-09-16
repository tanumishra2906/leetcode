class Solution{
    public int numberOfSets(int n,int k){
        long ans=1;
        long mod=1000000007;

        int r=2*k;

        for(int i=1;i<=r;i++){
            ans=ans*(n+k-1-r+i)%mod;
            ans=ans*modInverse(i,mod)%mod;
        }

        return (int)ans;
    }

    private long modInverse(long a,long mod){
        return power(a,mod-2,mod);
    }

    private long power(long a,long b,long mod){
        long result=1;

        while(b>0){
            if((b&1)==1){
                result=result*a%mod;
            }

            a=a*a%mod;
            b>>=1;
        }

        return result;
    }
}