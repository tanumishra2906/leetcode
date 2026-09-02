bool isPalindrome(int x) {
    int rev=0;
    int temp=x;

    if(x<0)
        return false;

    while(temp>0){

        if(rev > 214748364)
            return false;

        rev=rev*10 + temp%10;
        temp=temp /10;
    }
    return rev==x;
    
}