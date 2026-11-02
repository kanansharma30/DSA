class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // cost(i)=|s[i]-t[i]|
        ///s = "abcd"
        // t ="bcdf"
        // index at 0 s[i]= a and t[i] = b cost = 1
        // index at 1 s[i] = b and t[i] = c cost =1
        // index at 0 s[i]= c and t[i] = d cost = 1
        // index at 1 s[i] = d and t[i] = f cost =2

        // 1+1+1+2 = 5
        // but we will only do first 3 index here as we have maxCost = 3

        //LOGIC:
        // Variable size sliding window:
        // two pointers
        // left: window strating index
        // right: window ke ending index
        // currentCost = 
        // maxLength = abh tak milne wlai sabhse longest window ki length

        int left = 0;
        int currentCost = 0;
        int maxLength = 0;
        for(int right = 0; right<s.length(); right++){
            currentCost += Math.abs(s.charAt(right)- t.charAt(right));
            while(currentCost>maxCost){
                currentCost-= Math.abs(s.charAt(left)-t.charAt(left));
                left++;

            }
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}
