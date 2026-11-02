class Solution {
    public int lengthOfLongestSubstring(String s) {
        // create array 
        // transversing the string from right to end
        //each frequency while iterating, (freq>1 means duplicate)
        // when we have duplicate we move left forward to decrease frequency until duplicate is removed
        //subtring calculated

        int[] arr = new int[128];
        int left = 0;
        int maxLength = 0;

        for (int i =0; i<s.length(); i++){
            arr[s.charAt(i)]++;

            while(arr[s.charAt(i)]>1){
                arr[s.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;


    }
}
