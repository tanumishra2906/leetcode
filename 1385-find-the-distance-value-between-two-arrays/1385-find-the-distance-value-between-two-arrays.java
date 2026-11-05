class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int i=0;i<arr1.length;i++){
            boolean valid = true;
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    valid=false;
                }

            }
            if(valid==true){
                count++;
            }
        }
        return count;

        
    }
}

/*The question gives us two integer arrays, `arr1` and `arr2`, and an integer `d`. We have to find the number of elements in `arr1` whose absolute difference with every element of `arr2` is strictly greater than `d`. In simple words, for each element of `arr1`, we compare it with all elements of `arr2`. If even one element has an absolute difference less than or equal to `d`, we don't count it. If all differences are greater than `d`, we increment our count. Finally, we return the total count. */
