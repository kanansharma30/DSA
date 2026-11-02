class Solution {
    public int totalFruit(int[] fruits) {

        // create a freq array to store fruit types
        // initialize kro left = 0 and maxLength = 0
        //traverse the fruits array using right
        //increase the freq of the current fruit
        // if more than two distinct fruit types exist:
        // decrease the freq of the fruit at left
        //move left forward
        // continue until only two types remain
        // calculate the current window length
        //update maxLength
        // eturn maxLength

        int [] freq = new int[fruits.length];
        int left = 0;
        int maxLength = 0;
        int types = 0;

        for(int right = 0; right<fruits.length; right++){
            if(freq[fruits[right]]==0){
                types++;
            }
            freq[fruits[right]]++;
            while(types>2) {
                freq[fruits[left]]--;

                if(freq[fruits[left]] == 0){
                    types--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }  
        return maxLength; 
    }
}
