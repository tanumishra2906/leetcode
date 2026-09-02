

int fib(int n){
    int term1=0 , term2=1, newnum;
    if(n==0){
        return 0;
    }
   
    if(n==1){
        return 1;
    }
    
    for(int i=2;i<=n;i++){
        newnum = term1+term2;
        term1 = term2;
        term2 = newnum;
    } return newnum;

}